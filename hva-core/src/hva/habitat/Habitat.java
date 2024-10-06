package hva.habitat;

import java.io.Serializable;
import java.util.HashMap;
import hva.Species;
import hva.animal.Animal;
import hva.Tree;

import java.util.HashMap;

public class Habitat implements Serializable{
    private String _id;
    private String _name;
    private int _area;
    private HashMap<String, Tree> _trees;
    private HashMap<String, Animal> _animals;
    private HashMap<Species, String> _influence;

    public Habitat(String id, String name, int area) {
        _id = id;
        _name = name;
        _area = area;
        _trees = new HashMap<>();
        _animals = new HashMap<>();
        _influence = new HashMap<>();
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public int getArea() {
        return _area;
    }

    public HashMap<String, Tree> getTrees() {
        return _trees;
    }

    public HashMap<String, Animal> getAnimals() {
        return _animals;
    }

    public HashMap<Species, String> getInfluence() {
        return _influence;
    }

    public void addTree(String treeId, Tree tree) {
        _trees.put(treeId, tree);
    }

    public void addAnimal(String animalId, Animal animal) {
        _animals.put(animalId, animal);
    }

    public void addInfluence(Species species, String description) {
        _influence.put(species, description);
    }
}

