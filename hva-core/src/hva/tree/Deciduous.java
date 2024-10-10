package hva.tree;

import hva.Seasons.Season;

/**
 * Class representing a deciduous tree.
 * Inherits from the Tree class and includes additional properties specific to deciduous trees.
 */
public class Deciduous extends Tree {

    // Type of leaves for the deciduous tree
    private String _leafType;

    /**
     * Constructor for the Deciduous tree.
     * 
     * @param id             Unique identifier for the tree.
     * @param name           Name of the tree.
     * @param age            Age of the tree.
     * @param baseCleaningDiff Base cleaning difficulty associated with the tree.
     * @param currentSeason  Current season affecting the tree's behavior.
     * @param type           Type of leaves (e.g., broadleaf, needleleaf).
     */
    public Deciduous(String id, String name, int age, int baseCleaningDiff, Season currentSeason, String type) {
        super(id, name, age, baseCleaningDiff, currentSeason);
        _leafType = type; // Set the leaf type for this deciduous tree
    }

    /**
     * Returns a string representation of the Deciduous tree.
     * 
     * @return A formatted string containing the tree's attributes and its current seasonal cycle.
     */
    @Override
    public String toString() {
        return super.toString() + "|" + _leafType + "|" + _currentSeason.getDeciduousCycle();
    }
}
