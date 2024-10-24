package hva.tree;

import hva.Seasons.Season;
import hva.visitor.Visitor;

/**
 * Class representing a deciduous tree.
 * Inherits from the Tree class and includes additional properties specific to deciduous trees.
 */
public class Deciduous extends Tree {

    /**
     * Constructor for the Deciduous tree.
     * 
     * @param id             Unique identifier for the tree.
     * @param name           Name of the tree.
     * @param age            Age of the tree.
     * @param baseCleaningDiff Base cleaning difficulty associated with the tree.
     * @param currentSeason  Current season affecting the tree's behavior.
     */
    public Deciduous(String id, String name, int age, int baseCleaningDiff, Season currentSeason) {
        super(id, name, age, baseCleaningDiff, currentSeason);
    }

    /**
     * Gets the leaf type from this tree.
     * 
     * @return A string of the leaf type
     */
    public String getLeafType() {
      return "CADUCA";
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
