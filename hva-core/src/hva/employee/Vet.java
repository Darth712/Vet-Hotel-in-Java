package hva.employee;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import hva.Species;

public class Vet extends Employee{
    private Map<String, Species> _responsability;

    public Vet(String id, String name) {
        super(id,name);
        _responsability = new TreeMap<String,Species>();
    }

    public String getId() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }
}

