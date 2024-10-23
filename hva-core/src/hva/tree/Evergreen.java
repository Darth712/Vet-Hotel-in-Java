package hva.tree;

import hva.Seasons.Season;

import hva.visitor.Visitor;

/**
 * Class representing an evergreen tree.
 * Inherits from the Tree class and includes properties specific to evergreen trees.
 */
public class Evergreen extends Tree {

 
   

    /**
     * Constructor for the Evergreen tree.
     * 
     * @param id             Unique identifier for the tree.
     * @param name           Name of the tree.
     * @param age            Age of the tree.
     * @param baseCleaningDiff Base cleaning difficulty associated with the tree.
     * @param currentSeason  Current season affecting the tree's behavior.
     * @param type           Type of leaves (e.g., needle leaves).
     */
    public Evergreen(String id, String name, int age, int baseCleaningDiff, Season currentSeason, String type) {
        super(id, name, age, baseCleaningDiff, currentSeason);
        _leafType = type; // Set the leaf type for this evergreen tree
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
