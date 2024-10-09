package hva.tree;

import hva.Seasons.Season;

public class Deciduous extends Tree{



    public Deciduous(String id, String name, int age, int baseCleaningDiff, Season currentSeason, String type) {
        super(id, name, age, baseCleaningDiff, currentSeason);
        _leafType = type;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + _leafType +"|" +_currentSeason.getDeciduousCycle();
    }
    
}
