package hva;

import java.io.Serializable;
import java.util.List;

public class Vaccine implements Serializable{

    private String _id;
    private String _name;
    private List<Species> _applicableSpecies;


    public Vaccine(String id, String name, String species) {
        _id = id;
        _name = name;
        // parse das species para dps meter uma a uma no applicableSpecies
    }

    
    
}
