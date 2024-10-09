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



//FIXME import other Java classes
//FIXME import project classes

public class Hotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081733L;

    private Season _currentSeason;
    private Map<String,Habitat> _habitats = new TreeMap<String,Habitat>();
    private Map<String,Animal> _animals = new TreeMap<String,Animal>();
    private Map<String,Species> _species = new TreeMap<String,Species>();
    private Map<String,Employee> _employees = new TreeMap<String,Employee>();
    private Map<String,Vaccine> _vaccines = new TreeMap<String,Vaccine>();
    private Map<String,Tree> _trees = new TreeMap<String,Tree>();
    private List<Vaccination> _vaccinations = new ArrayList<Vaccination>();
    private boolean _changed;


    public Map<String,Habitat> getHabitats() {
      return _habitats;
    }

    public void setChanged(boolean bool){ _changed = bool;}
    public void changed() { _changed = true;}
    public boolean hasChanged() { return _changed;}

    /**
     * Read text input file and create domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    public void importFile(String filename) throws ImportFileException {
      try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");

            switch (parts[0].toUpperCase()) {
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

    private void parseSpecies(String[] parts) {
      String id = parts[1];
      String name = parts[2];
      
      
      Species species = new Species(id, name);
      _species.put(id, species);
    }

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

    private void parseHabitat(String[] parts) {
      String id = parts[1];
      String name = parts[2];
      int area = Integer.parseInt(parts[3]);
  
      Habitat habitat = new Habitat(id, name, area);
  
      // Parse trees in habitat
      if (parts.length > 4) {
        String[] treeIds = parts[4].split(",");
        for (String treeId : treeIds) {
            Tree tree = _trees.get(treeId);
            if (tree != null) {
                habitat.addTree(treeId,tree);
            }
        }
      }
  
      _habitats.put(id, habitat);
    }

    private void parseAnimal(String[] parts) throws UnrecognizedEntryException{
      String id = parts[1];
      String name = parts[2];
      Species species = _species.get(parts[3]);
      
      Habitat habitat = _habitats.get(parts[4]);
  
      if (species == null || habitat == null) {
          throw new UnrecognizedEntryException("Species or Habitat not found for Animal: " + id);
      }
  
      Animal animal = new Animal(id, name, species, habitat);
      habitat.addAnimal(animal);
      species.addAnimal(animal);
  
    
      habitat.getAnimals().put(id, animal);
      _animals.put(id,animal);
    }

    private void parseHandler(String[] parts) {
      String id = parts[1];
      String name = parts[2];

  
      Handler handler = new Handler(id, name);
  
      // Parse habitats the handler manages
      if (parts.length > 3) {
        String[] habitatIds = parts[3].split(",");
        for (String habitatId : habitatIds) {
            Habitat habitat = _habitats.get(habitatId);
            if (habitat != null) {
                handler.addNewResponsability(habitatId);
            }
        }
      }
  
      _employees.put(id, handler);
    }

    private void parseVet(String[] parts) {
      String id = parts[1];
      String name = parts[2];
  
      Vet vet = new Vet(id, name);
  
      // Parse species the vet is responsible for
      if (parts.length >3) {
        String[] speciesIds = parts[3].split(",");
        for (String speciesId : speciesIds) {
            Species species = _species.get(speciesId);
            if (species != null) {
                vet.addNewResponsability(speciesId);
            }
        }
      }
      _employees.put(id, vet);
    }

    private void parseVaccine(String[] parts) {
      String id = parts[1];
      String name = parts[2];
  
      Vaccine vaccine = new Vaccine(id, name);
  
      // Parse species the vaccine applies to
      if (parts.length > 3) {
        String[] speciesIds = parts[3].split(",");
        for (String speciesId : speciesIds) {
            Species species = _species.get(speciesId);
            if (species != null) {
                vaccine.addSpecies(species);
            }
        }
      }
      _vaccines.put(id, vaccine);
    }

 

  public Collection<Habitat> ShowAllHabitats() {
  
    return Collections.unmodifiableCollection((_habitats.values()));

  }


  public void registerHabitat(String id, String name, int area) {
    _habitats.put(id, new Habitat(id, name, area));
    changed();

  }

  public Collection<Animal> ShowAllAnimals() {
    return Collections.unmodifiableCollection((_animals.values()));

  }

  public Collection<Employee> ShowAllEmployees() {
    return Collections.unmodifiableCollection((_employees.values()));

  }

  public Collection<Vaccine> ShowAllVaccines() {
    return Collections.unmodifiableCollection((_vaccines.values()));

  }



  





  


}