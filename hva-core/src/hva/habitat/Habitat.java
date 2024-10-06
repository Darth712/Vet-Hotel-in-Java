package hva.habitat;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import hva.Tree;
import hva.animal.Animal;

public class Habitat implements Serializable{

    private String _id;
    private String _name;
    private int _area;
    private Map<String,Tree> _trees;
    private Map<String,Animal> _animals;
    // influencia das especies


    public Habitat(String id, String name, int area) {
        _id = id;
        _name = name;
        _area = area;
        _trees = new HashMap<String,Tree>();
        _animals = new HashMap<String,Animal>();

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

    public void setArea(int area) {
        _area = area;
    }

    public void addNewTree(Tree tree) {
        _trees.put(tree.getId(), tree);
    }

    public void addNewAnimal(Animal animal) {
        _animals.put(animal.getId(), animal);
    }



    
}
