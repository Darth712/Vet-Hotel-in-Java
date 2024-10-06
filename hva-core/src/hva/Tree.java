package hva;

import java.io.Serializable;





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

    public String name() {
        return _name;
    }

    public int age() {
        return _age;
    }
    
    public void addAge() {
        _age++;
    }

    



    
}
