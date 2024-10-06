package hva.employee;


import java.util.List;



public class Handler extends Employee{

  
    private List<String> _responsability;

    public Handler(String id, String name) {
        super(id,name);
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
