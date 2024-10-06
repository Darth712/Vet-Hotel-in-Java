package hva.employee;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


public class Handler extends Employee{

  
    private List<String> _responsability;

    public Handler (String id, String name) {
        super(id, name);
        _responsability = new ArrayList<String>();
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
