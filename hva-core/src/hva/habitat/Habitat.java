package hva.habitat;

import java.io.Serializable;
import java.util.HashMap;
import hva.Species;
import hva.animal.Animal;
import java.util.Map;
import hva.Tree;


public class Habitat implements Serializable{

    private String _id;
    private String _name;
    private int _area;
    private HashMap<String,Tree> _trees;
    private HashMap<String,Animal> _animals;
    private HashMap<String,Species> _influence;


    public Habitat(String id, String name, int area) {
        _id = id;
        _name = name;
        _area = area;
        _trees = new HashMap<String,Tree>();
        _animals = new HashMap<String,Animal>();
        _influence = new HashMap<String,Species>();
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

    public HashMap<String, Species> getInfluence() {
        return _influence;
    }

    public void addTree(String treeId, Tree tree) {
        _trees.put(treeId, tree);
    }

    public void addAnimal(Animal animal) {
        _animals.put(animal.getId(), animal);
    }

    public void addInfluence(Species species, String description) {
        _influence.put(description, species);
    }
    public void setArea(int area) {
        _area = area;
    }

    public void addNewTree(Tree tree) {
        _trees.put(tree.getId(), tree);
    }

    public void addNewAnimal(Animal animal) {
        _animals.put(animal.getId(), animal);
    }

    public int numOfTrees() {
        return _trees.size();
    }

    @Override
    public String toString() {
        return "HABITAT|" + _id + "|" + _name +"|" +_area+"|"+this.numOfTrees();
    }


    
}

