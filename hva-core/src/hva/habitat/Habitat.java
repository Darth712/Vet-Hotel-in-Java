package hva.habitat;

import java.io.Serial;
import java.io.Serializable;
import java.util.TreeMap;
import hva.animal.Animal;
import hva.tree.Tree;
import hva.visitor.*;
import java.util.Collection;
import hva.employee.Handler;

/**
 * Class representing a Habitat, which contains trees, animals, and influences (species).
 */
public class Habitat implements Serializable, Visitable{

    @Serial
    private static final long serialVersionUID = 202407081736L;

    private String _id;                         // Habitat ID
    private String _name;                       // Habitat name
    private int _area;                          // Habitat area
    private TreeMap<String, Tree> _trees;       // Map of trees
    private TreeMap<String, Animal> _animals;   // Map of animals
    private TreeMap<String, String> _influence; // Map of influences
    private TreeMap<String, Handler> _handlers; // Map of handlers

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
        _handlers = new TreeMap<String, Handler>();
    }

    /**
     * Gets the habitat's ID
     * 
     *  @return the habitat's unique ID
     */
    public String getId() {
        return _id;
    }

    /**
     * Gets the habitat's name
     * 
     *  @return the name of the habitat 
     */
    public String getName() {
        return _name;
    }

    /**
     * Gets the habitat's area
     * 
     *  @return the area of the habitat 
     */
    public int getArea() {
        return _area;
    }

    /**
     * Gets the trees living in this habitat
     * 
     *  @return the collection of trees in the habitat 
     */
    public TreeMap<String, Tree> getTrees() {
        return _trees;
    }

    /**
     * Gets the animals living in this habitat
     * 
     *  @return the collection of animals in the habitat 
     */
    public TreeMap<String, Animal> getAnimals() {
        return _animals;
    }

    /**
     * Gets the influence from the species
     * 
     *  @return the collection of species influencing the habitat 
     */
    public TreeMap<String, String> getInfluence() {
        return _influence;
    }

    /**
     * Gets the handlers working in this habitat
     * 
     * @return
     */
    public TreeMap<String, Handler> getHandlers() {
        return _handlers;
    }

    /**
     * Gets a collection of all the trees from the habitat
     * 
     * @return A collection of all trees
     */
    public Collection<Tree> getAllTrees() {
        return getTrees().values();
    }
    
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
     * Adds a handler to the habitat's map
     * 
     * @param handler
     */
    public void addHandler(Handler handler) {
        _handlers.put(handler.getId(), handler); 
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
