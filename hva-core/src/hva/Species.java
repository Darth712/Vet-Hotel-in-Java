package hva;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import hva.animal.Animal;

public class Species implements Serializable {
    private String _id;
    private String _name;
    private static int _population;
    private Map<String, Animal> _animals;

    public Species(String id, String name) {
        _id = id;
        _name = name;
        _population++;
        _animals = new HashMap<>();
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public int getPopulation() {
        return _population;
    }

    public Map<String, Animal> getAnimals() {
        return _animals;
    }

    public void addAnimal(Animal animal) {
        _animals.put(animal.getId(), animal);
    }

    public void increasePopulation() {
        _population++;
    }

    public void decreasePopulation() {
        _population--;
    }
}

