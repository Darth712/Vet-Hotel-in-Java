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

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public void use() {
        _timesUsed++;
    }

    public int getTimesUsed() {
        return _timesUsed;
    }

    public String speciesString() {
        if (_applicableSpecies == null || _applicableSpecies.isEmpty()) {
            return ""; // Return empty string if the list is empty or null
        }
    
        // Initialize ans with the first element
        String ans = "|" + _applicableSpecies.get(0);
    
        // Loop through the rest of the list starting from index 1
        for (int i = 1; i < _applicableSpecies.size(); i++) {
            ans += "," + _applicableSpecies.get(i);
        }
    
        return ans;
    }

    @Override
    public String toString() {
        return "VACINA|" + _id +"|" +_name +"|"+_timesUsed+this.speciesString();
    }

}
