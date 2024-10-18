package hva;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import hva.animal.Animal;
import hva.employee.Vet;
/**
 * Class representing a species of animals.
 * Implements Serializable for object serialization.
 */
public class Species implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081738L;

    private String _id;                      // Unique identifier for the species
    private String _name;                    // Name of the species
    private Map<String, Animal> _animals;    // Map to store animals of this species
    private Map<String, Vet> _vets;
    /**
     * Constructor for the Species class.
     *
     * @param id   Unique identifier for the species.
     * @param name Name of the species.
     */
    public Species(String id, String name) {
        _id = id;
        _name = name;                // Increment population when a new species is created
        _animals = new TreeMap<>();      // Initialize the map to store animals
    }

    /**
     * Gets the unique identifier of the species.
     *
     * @return The unique identifier of the species.
     */
    public String getId() {
        return _id;
    }

    /**
     * Gets the name of the species.
     *
     * @return The name of the species.
     */
    public String getName() {
        return _name;
    }

    /**
     * Gets the current population of the species.
     *
     * @return The current population of the species.
     */
    public int getPopulation() {
        return _animals.size();     
    }

    

    /**
     * Gets the map of animals belonging to this species.
     *
     * @return A map of animals identified by their IDs.
     */
    public Map<String, Animal> getAnimals() {
        return _animals;                         
    }
    public Map<String, Vet> getVets() {
        return _vets;                         
    }
    
    public void addVet(Vet vet) {
        _vets.put(vet.getId(),vet);
    }

    /**
     * Adds an animal to the species.
     *
     * @param animal The animal to be added.
     */
    public void addAnimal(Animal animal) {
        _animals.put(animal.getId(), animal);  // Store the animal in the map using its ID
    }

  
}
