package hva;

import java.io.Serializable;

import java.util.EnumMap;

public class Tree implements Serializable{

    private String _id;
    private String _name;
    private int _age ;
    private LeafType _leafType;
    private int _baseCleaningDiff;
    private Season _currentSeason;

    public Tree(String id, String name, int age, LeafType leafType, int baseCleaningDiff, Season currentSeason) {
        _id = id;
        _name = name;
        _age = age;
        _leafType = leafType;
        _baseCleaningDiff = baseCleaningDiff;
        _currentSeason = currentSeason;
    }

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
}
