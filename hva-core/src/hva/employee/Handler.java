package hva.employee;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import hva.habitat.Habitat;

import java.util.List;



public class Handler extends Employee{

  
    private List<String> _responsability;

    public Handler (String id, String name) {
        super(id, name);
        _responsability = new List<Habitat>();
    }

    @Override
    public void addNewResponsability(String id) {
        _responsability.add(id);
    }
    
    @Override
    public String getType() {
        return "TRT";
    }



    
    
}
