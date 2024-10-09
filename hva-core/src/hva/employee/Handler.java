package hva.employee;


import java.util.ArrayList;


public class Handler extends Employee{

  
    

    public Handler(String id, String name) {
        super(id, name);
        _responsability = new ArrayList<String>(); // com o id dos habitats
    }

    @Override
    public void addNewResponsability(String id) {
        _responsability.add(id);
    }
    
    @Override
    public String getType() {
        return "TRT";
    }

    
    @Override
    public String toString() {
        return this.getType() + super.toString() + this.responsabilityString();
    }




    
    
}
