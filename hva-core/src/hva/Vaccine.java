package hva;

import java.io.Serializable;
import hva.Species;
import java.util.List;

public class Vaccine implements Serializable{
    private String _id;
    private String _name;
    private int _timesUsed;
    private List<Species> _applicableSpecies;

    public Vaccine (String id, String name, int timesUsed) {
        _id = id;
        _name = name;
        _timesUsed = timesUsed;
        _applicableSpecies = new List<Species>();
    }  
}
