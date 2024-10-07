package hva.employee;

import java.io.Serializable;
import java.util.List;


public abstract class Employee implements Serializable{

    private String _id;
    private String _name;
    protected List<String> _responsability;

    public Employee(String id, String name) {
        _id = id;
        _name = name;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public abstract String getType();

    public abstract void addNewResponsability(String id);


    public String responsabilityString() {
        if (_responsability == null || _responsability.isEmpty()) {
            return ""; // Return empty string if the list is empty or null
        }
    
        // Initialize ans with the first element
        String ans = "|" + _responsability.get(0);
    
        // Loop through the rest of the list starting from index 1
        for (int i = 1; i < _responsability.size(); i++) {
            ans += "," + _responsability.get(i);
        }
    
        return ans;
    }

    @Override
    public String toString() {
        return "|" + _id + "|" + _name;
    }
    
}
