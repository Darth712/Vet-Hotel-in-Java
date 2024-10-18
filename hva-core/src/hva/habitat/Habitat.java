package hva.habitat;

import java.io.Serial;
import java.io.Serializable;

import java.util.TreeMap;
import hva.Species;
import hva.animal.Animal;
import hva.tree.Tree;
import hva.visitor.*;

/**
 * Class representing a Habitat, which contains trees, animals, and influences (species).
 */
public class Habitat implements Serializable, Visitable{

    @Serial
    private static final long serialVersionUID = 202407081736L;

    /** The unique identifier of the habitat. */
    private String _id;

    /** The name of the habitat. */
    private String _name;

    /** The area of the habitat (in square meters, for example). */
    private int _area;

    /** A collection of trees present in the habitat, mapped by tree ID. */
    private TreeMap<String, Tree> _trees;

    /** A collection of animals present in the habitat, mapped by animal ID. */
    private TreeMap<String, Animal> _animals;

    /** A collection of species influencing the habitat, mapped by descriptions. */
    private TreeMap<String, String> _influence;



    /**
     * Constructs a Habitat object with the specified ID, name, and area.
     * Initializes empty maps for trees, animals, and influence species.
     * 
     * @param id    the unique identifier for the habitat
     * @param name  the name of the habitat
     * @param area  the area of the habitat
     */
    public Habitat(String id, String name, int area) {
        _id = id;
        _name = name;
        _area = area;
        _trees = new TreeMap<String, Tree>();
        _animals = new TreeMap<String, Animal>();
        _influence = new TreeMap<String, String>();
    }

    // Getters
    /** @return the habitat's unique ID */
    public String getId() {
        return _id;
    }

    /** @return the name of the habitat */
    public String getName() {
        return _name;
    }

    /** @return the area of the habitat */
    public int getArea() {
        return _area;
    }

    /** @return the collection of trees in the habitat */
    public TreeMap<String, Tree> getTrees() {
        return _trees;
    }

    /** @return the collection of animals in the habitat */
    public TreeMap<String, Animal> getAnimals() {
        return _animals;
    }

    /** @return the collection of species influencing the habitat */
    public TreeMap<String, String> getInfluence() {
        return _influence;
    }

    //Setters
    /**
     * Sets the area of the habitat.
     * 
     * @param area the new area of the habitat
     */
    public void setArea(int area) {
        _area = area;
    }




    /**
     * Adds a tree to the habitat.
     * 
     * @param treeId the unique ID of the tree
     * @param tree   the Tree object to be added
     */
    public void addTree(String treeId, Tree tree) {
        _trees.put(treeId, tree);
    }

    /**
     * Adds an animal to the habitat.
     * 
     * @param animal the Animal object to be added
     */
    public void addAnimal(Animal animal) {
        _animals.put(animal.getId(), animal);
    }

    /**
     * Adds a species to the influence map of the habitat.
     * 
     * @param speciesId     the species influencing the habitat
     * @param influence   the influence
     */
    public void addInfluence(String speciesId, String influence) {
        _influence.put(speciesId, influence);
    }

    /**
     * Adds a new tree to the habitat.
     * 
     * @param tree the Tree object to be added
     */
    public void addNewTree(Tree tree) {
        _trees.put(tree.getId(), tree);
    }

    /**
     * Adds a new animal to the habitat.
     * 
     * @param animal the Animal object to be added
     */
    public void addNewAnimal(Animal animal) {
        _animals.put(animal.getId(), animal);
    }

    /**
     * @return the number of trees in the habitat
     */
    public int numOfTrees() {
        return _trees.size();
    }


    /**
     * Accepts a visitor and allows it to perform operations on this instance.
     * Part of the Visitor design pattern.
     * 
     * @param <T> the type of the result produced by the visitor
     * @param visitor the visitor performing the operation
     * @return the result of the visitor's operation, String
     */
    @Override
    public <T> T accept(Visitor<T> visitor) {
      return visitor.visit(this);
    }
    
}
