package hva.tree;

import java.io.Serializable;

import hva.Seasons.Season;


public abstract class Tree implements Serializable{

    private String _id;
    private String _name;
    private int _age ;
    protected String _leafType;
    private int _baseCleaningDiff;
    protected Season _currentSeason;

    public Tree(String id, String name, int age, int baseCleaningDiff, Season currentSeason) {
        _id = id;
        _name = name;
        _age = age;
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

    public String getLeafType() {
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

    @Override
    public String toString() {
        return "ÁRVORE|" + _id +"|"+_name+"|"+_age+"|"+_baseCleaningDiff;
    }



}

