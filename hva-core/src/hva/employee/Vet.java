package hva.employee;

import java.io.Serializable;
import hva.Species;
import java.util.List;


public class Vet extends Employee{

    private Map<String, Species> _responsability;

    public Vet(String id, String name) {
        super(id,name);
        _responsability = new List<Species>();
    }

    public String getName() {
        return super.getName();
    }

    public String getId() {
        return super.getId();
    }

    @Override
    public void addNewResponsability(String id) {
        _responsability.add(id);
    }

    @Override
    public String getType() {
        return "VET";
    }
    
}

