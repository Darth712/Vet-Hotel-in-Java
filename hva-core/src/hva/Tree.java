package hva;

import java.io.Serializable;

import java.util.EnumMap;

public class Tree implements Serializable{

    private String _id;
    private String _name;
    private int _age = 0;
    // LEAFTYPE : ENUM
    private int _baseCleaningDiff;
    private Season _currentSeason;

    // CONSTRUCTOR FOR TREE

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public int getAge() {
        return _age;
    }

    public LeafType getLeafType() {
        return _leafType;
    }

    public int getBaseCleaningDifficulty() {
        return _baseCleaningDiff;
    }

    public Season getCurrentSeason() {
        return _currentSeason;
    }

    public void setCurrentSeason(Season currentSeason) {
        _currentSeason = currentSeason;
    }
}

enum LeafType {
    CADUCA, PERENE;

    public int age() {
        return _age;
    }
    
    public void addAge() {
        _age++;
    }

    



    
}
