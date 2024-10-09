package hva;

import java.io.Serial;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import hva.exceptions.ImportFileException;
import hva.exceptions.UnrecognizedEntryException;
import hva.Seasons.*;
import hva.animal.*;
import hva.employee.*;
import hva.habitat.*;
import hva.tree.Deciduous;
import hva.tree.Evergreen;
import hva.tree.Tree;

import java.util.Map;

import java.util.TreeMap;
import java.util.HashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This class represents a hotel that hosts animals and trees in various habitats. 
 * It manages animals, employees, habitats, species, vaccines, and trees.
 */
public class Hotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081733L;

    private Season _currentSeason;
    private Map<String, Habitat> _habitats = new TreeMap<String, Habitat>();  
    private Map<String, Animal> _animals = new TreeMap<String, Animal>();  
    private Map<String, Species> _species = new TreeMap<String, Species>();  
    private Map<String, Employee> _employees = new TreeMap<String, Employee>(); 
    private Map<String, Vaccine> _vaccines = new TreeMap<String, Vaccine>(); 
    private Map<String, Tree> _trees = new TreeMap<String, Tree>(); 
    private List<Vaccination> _vaccinations = new ArrayList<Vaccination>();
    private boolean _changed;

    /**
     * Gets the map of habitats.
     * 
     * @return the habitats map
     */
    public Map<String, Habitat> getHabitats() {
        return _habitats;
    }

    /**
     * Sets the changed status of the hotel.
     * 
     * @param bool true if the data has changed
     */
    public void setChanged(boolean bool) { 
        _changed = bool;
    }

    /**
     * Marks the hotel data as changed.
     */
    public void changed() { 
        _changed = true;
    }

    /**
     * Checks if the hotel data has changed.
     * 
     * @return true if the data has changed
     */
    public boolean hasChanged() { 
        return _changed;
    }

    /**
     * Reads a text input file and creates corresponding domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException if there is an error importing the file
     */
    public void importFile(String filename) throws ImportFileException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");  // Splits the line into parts using '|' as a delimiter

                switch (parts[0].toUpperCase()) {  // First part determines the entity type
                    case "ESPÉCIE":
                        parseSpecies(parts);
                        break;
                    case "ÁRVORE":
                        parseTree(parts);
                        break;
                    case "HABITAT":
                        parseHabitat(parts);
                        break;
                    case "ANIMAL":
                        parseAnimal(parts);
                        break;
                    case "TRATADOR":
                        parseHandler(parts);
                        break;
                    case "VETERINÁRIO":
                        parseVet(parts);
                        break;
                    case "VACINA":
                        parseVaccine(parts);
                        break;
                    default:
                        throw new UnrecognizedEntryException("Unrecognized entry: " + parts[0]);
                }
            }
        } catch (IOException | UnrecognizedEntryException e) {
            throw new ImportFileException(filename, e);
        }
    }

    /**
     * Parses the species entry and creates a species object.
     * 
     * @param parts array of strings representing the species data
     */
    private void parseSpecies(String[] parts) {
        String id = parts[1];
        String name = parts[2];
        
        Species species = new Species(id, name);  // Creates a new species object
        _species.put(id, species);  // Adds the species to the species map
    }

    /**
     * Parses the tree entry and creates a tree object.
     * 
     * @param parts array of strings representing the tree data
     */
    private void parseTree(String[] parts) {
      String id = parts[1];
      String name = parts[2];
      int age = Integer.parseInt(parts[3]);
      int difficulty = Integer.parseInt(parts[4]);
      String type = parts[5].toUpperCase();
      
      if (type == "PERENE") {
        Evergreen tree = new Evergreen(id, name, age, difficulty, _currentSeason, type);
       _trees.put(id, tree);
      }
      if (type == "CADUCA") {
        Deciduous tree = new Deciduous(id, name, age, difficulty, _currentSeason, type);
       _trees.put(id, tree);
      }

    }

    /**
     * Parses the habitat entry and creates a habitat object.
     * 
     * @param parts array of strings representing the habitat data
     */
    private void parseHabitat(String[] parts) {
        String id = parts[1];
        String name = parts[2];
        int area = Integer.parseInt(parts[3]);

        Habitat habitat = new Habitat(id, name, area);  // Creates a new habitat object

        // If the entry includes tree IDs, add those trees to the habitat
        if (parts.length > 4) {
            String[] treeIds = parts[4].split(",");
            for (String treeId : treeIds) {
                Tree tree = _trees.get(treeId);
                if (tree != null) {
                    habitat.addTree(treeId, tree);  // Adds trees to the habitat
                }
            }
        }

        _habitats.put(id, habitat);  // Adds the habitat to the habitats map
    }

    /**
     * Parses the animal entry and creates an animal object.
     * 
     * @param parts array of strings representing the animal data
     * @throws UnrecognizedEntryException if species or habitat is not found
     */
    private void parseAnimal(String[] parts) throws UnrecognizedEntryException {
        String id = parts[1];
        String name = parts[2];
        Species species = _species.get(parts[3]);
        Habitat habitat = _habitats.get(parts[4]);

        if (species == null || habitat == null) {
            throw new UnrecognizedEntryException("Species or Habitat not found for Animal: " + id);
        }

        Animal animal = new Animal(id, name, species, habitat);  // Creates a new animal object
        habitat.addAnimal(animal);  // Adds the animal to the habitat
        species.addAnimal(animal);  // Adds the animal to the species

        habitat.getAnimals().put(id, animal);  // Adds the animal to the animals map in the habitat
        _animals.put(id, animal);  // Adds the animal to the global animals map
    }

    /**
     * Parses the handler (employee) entry and creates a handler object.
     * 
     * @param parts array of strings representing the handler data
     */
    private void parseHandler(String[] parts) {
        String id = parts[1];
        String name = parts[2];

        Handler handler = new Handler(id, name);  // Creates a new handler object

        // If the entry includes habitat IDs, assign those habitats to the handler
        if (parts.length > 3) {
            String[] habitatIds = parts[3].split(",");
            for (String habitatId : habitatIds) {
                Habitat habitat = _habitats.get(habitatId);
                if (habitat != null) {
                    handler.addNewResponsability(habitatId);  // Assigns responsibility for the habitat to the handler
                }
            }
        }

        _employees.put(id, handler);  // Adds the handler to the employees map
    }

    /**
     * Parses the vet (employee) entry and creates a vet object.
     * 
     * @param parts array of strings representing the vet data
     */
    private void parseVet(String[] parts) {
        String id = parts[1];
        String name = parts[2];

        Vet vet = new Vet(id, name);  // Creates a new vet object

        // If the entry includes species IDs, assign those species to the vet
        if (parts.length > 3) {
            String[] speciesIds = parts[3].split(",");
            for (String speciesId : speciesIds) {
                Species species = _species.get(speciesId);
                if (species != null) {
                    vet.addNewResponsability(speciesId);  // Assigns responsibility for the species to the vet
                }
            }
        }

        _employees.put(id, vet);  // Adds the vet to the employees map
    }

    /**
     * Parses the vaccine entry and creates a vaccine object.
     * 
     * @param parts array of strings representing the vaccine data
     */
    private void parseVaccine(String[] parts) {
        String id = parts[1];
        String name = parts[2];

        Vaccine vaccine = new Vaccine(id, name);  // Creates a new vaccine object

        // If the entry includes species IDs, associate the vaccine with those species
        if (parts.length > 3) {
            String[] speciesIds = parts[3].split(",");
            for (String speciesId : speciesIds) {
                Species species = _species.get(speciesId);
                if (species != null) {
                    vaccine.addSpecies(species);  // Associates the vaccine with the species
                }
            }
        }

        _vaccines.put(id, vaccine);  // Adds the vaccine to the vaccines map
    }

    /**
     * Displays all habitats in an unmodifiable collection.
     * 
     * @return a collection of all habitats
     */
    public Collection<Habitat> ShowAllHabitats() {
        return Collections.unmodifiableCollection(_habitats.values());
    }

    /**
     * Registers a new habitat.
     * 
     * @param id    the habitat's ID
     * @param name  the habitat's name
     * @param area  the habitat's area
     */
    public void registerHabitat(String id, String name, int area) {
        _habitats.put(id, new Habitat(id, name, area));  // Adds the new habitat
        changed();  // Marks the hotel data as changed
    }

    /**
     * Displays all animals in an unmodifiable collection.
     * 
     * @return a collection of all animals
     */
    public Collection<Animal> ShowAllAnimals() {
        return Collections.unmodifiableCollection(_animals.values());
    }

    /**
     * Displays all employees in an unmodifiable collection.
     * 
     * @return a collection of all employees
     */
    public Collection<Employee> ShowAllEmployees() {
        return Collections.unmodifiableCollection(_employees.values());
    }

    /**
     * Displays all vaccines in an unmodifiable collection.
     * 
     * @return a collection of all vaccines
     */
    public Collection<Vaccine> ShowAllVaccines() {
        return Collections.unmodifiableCollection(_vaccines.values());
    }
}