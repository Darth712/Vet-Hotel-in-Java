package hva.employee;

import java.io.Serializable;
import hva.Species;
import java.util.List;
import java.util.ArrayList;


public class Vet extends Employee{


    public Vet(String id, String name) {
        super(id,name);
        _responsability = new ArrayList<String>();
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

    @Override
    public String toString() {
        return this.getType() + super.toString() + this.responsabilityString();
    }
}

