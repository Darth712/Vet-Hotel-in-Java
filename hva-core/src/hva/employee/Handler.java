package hva.employee;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import hva.habitat.Habitat;

public class Handler extends Employee implements Serializable{


    private Map<String, Habitat> _responsability;

    public Handler (String id, String name) {
        super(id, name);
        _responsability = new TreeMap<String, Habitat>();
    }
    
    
}
