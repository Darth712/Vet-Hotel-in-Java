package hva;

import java.io.Serializable;
import hva.Species;
import java.util.List;
import java.util.ArrayList;

public class Vaccine implements Serializable{
    private String _id;
    private String _name;
    private int _timesUsed;
    private List<Species> _applicableSpecies;

    public Vaccine (String id, String name) {
        _id = id;
        _name = name;
        _timesUsed = 0;
        _applicableSpecies = new ArrayList<Species>();
    }  

    public void addSpecies(Species applicabSpecies){
        _applicableSpecies.add(applicabSpecies);
    }
}
