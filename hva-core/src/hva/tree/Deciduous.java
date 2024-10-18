package hva.tree;

import hva.Seasons.Season;
import hva.Seasons.SeasonState;

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
     * @param type           Type of leaves (e.g., broadleaf, needleleaf).
     */
    public Deciduous(String id, String name, int age, int baseCleaningDiff, SeasonState currentSeason, String type) {
        super(id, name, age, baseCleaningDiff, currentSeason);
        _leafType = type; // Set the leaf type for this deciduous tree
    }

  
}
