package hva.habitat;

import java.io.Serializable;
import java.util.TreeMap;
import hva.Species;
import hva.animal.Animal;
import hva.tree.Tree;

import java.util.Map;


public class Habitat implements Serializable{

    private String _id;
    private String _name;
    private int _area;
    private TreeMap<String,Tree> _trees;
    private TreeMap<String,Animal> _animals;
    private TreeMap<String,Species> _influence;


    public Habitat(String id, String name, int area) {
        _id = id;
        _name = name;
        _area = area;
        _trees = new TreeMap<String,Tree>();
        _animals = new TreeMap<String,Animal>();
        _influence = new TreeMap<String,Species>();
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

    public TreeMap<String, Tree> getTrees() {
        return _trees;
    }

    public TreeMap<String, Animal> getAnimals() {
        return _animals;
    }

    public TreeMap<String, Species> getInfluence() {
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
        StringBuilder habitatInfo = new StringBuilder("HABITAT|" + _id + "|" + _name + "|" + _area + "|" + this.numOfTrees());
        
        if (_trees != null) {
            habitatInfo.append("\n");    
            for (Map.Entry<String, Tree> tree : _trees.entrySet()) {
                habitatInfo.append(tree.toString()).append("\n"); 
            }
        }
        return habitatInfo.toString();
    }
}

    


