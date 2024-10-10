package hva.tree;

import java.io.Serial;
import java.io.Serializable;
import hva.Seasons.Season;


/**
 * Abstract class representing a generic tree.
 * This class implements Serializable for object serialization.
 */
public abstract class Tree implements Serializable{

    @Serial
    private static final long serialVersionUID = 202407081733L;

    private String _id;                // Unique identifier for the tree
    private String _name;              // Name of the tree
    private int _age;                  // Age of the tree
    protected String _leafType;        // Type of leaves on the tree
    private int _baseCleaningDiff;     // Base cleaning difficulty of the tree
    protected Season _currentSeason;   // Current season affecting the tree's state

    /**
     * Constructor for the Tree class.
     * 
     * @param id              Unique identifier for the tree.
     * @param name            Name of the tree.
     * @param age             Age of the tree.
     * @param baseCleaningDiff Base cleaning difficulty associated with the tree.
     * @param currentSeason   Current season affecting the tree's behavior.
     */
    public Tree(String id, String name, int age, int baseCleaningDiff, Season currentSeason) {
        _id = id;
        _name = name;
        _age = age;
        _baseCleaningDiff = baseCleaningDiff;
        _currentSeason = currentSeason; // Set the current season for the tree
    }

    // Getters for the tree attributes

    /**
     * Gets the unique identifier of the tree.
     *
     * @return The unique identifier for the tree.
     */
    public String getId() {
        return _id; // Return the unique identifier
    }

    /**
     * Gets the name of the tree.
     *
     * @return The name of the tree.
     */
    public String getName() {
        return _name; // Return the name of the tree
    }

    /**
     * Gets the age of the tree.
     *
     * @return The age of the tree in years.
     */
    public int getAge() {
        return _age; // Return the age of the tree
    }

    /**
     * Gets the type of leaves on the tree.
     *
     * @return The leaf type as a string.
     */
    public String getLeafType() {
        return _leafType; // Return the type of leaves
    }

    /**
     * Gets the base cleaning difficulty of the tree.
     *
     * @return The base cleaning difficulty as an integer.
     */
    public int getBaseCleaningDifficulty() {
        return _baseCleaningDiff; // Return the base cleaning difficulty
    }

    /**
     * Gets the current season affecting the tree's state.
     *
     * @return The current season as a Season object.
     */
    public Season getCurrentSeason() {
        return _currentSeason; // Return the current season
    }

    /**
     * Sets the current season affecting the tree.
     *
     * @param currentSeason The current season to set.
     */
    public void setCurrentSeason(Season currentSeason) {
        _currentSeason = currentSeason; // Update the current season
    }


 
}
