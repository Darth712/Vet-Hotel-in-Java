package hva.employee;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Abstract class representing an employee in the system.
 * This class is meant to be extended by specific types of employees.
 */
public abstract class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081735L;

    /** The unique identifier for the employee. */
    private String _id;

    /** The name of the employee. */
    private String _name;

    /** A list of responsibilities (either habitats or species) the employee manages. */
    protected List<String> _responsability;

    /**
     * Constructs a new Employee with the specified ID and name.
     * 
     * @param id    the unique identifier for the employee
     * @param name  the name of the employee
     */
    public Employee(String id, String name) {
        _id = id;
        _name = name;
    }

    /**
     * Retrieves the employee's unique ID.
     * 
     * @return the employee's ID
     */
    public String getId() {
        return _id;
    }

    /**
     * Retrieves the employee's name.
     * 
     * @return the employee's name
     */
    public String getName() {
        return _name;
    }

    /**
     * Returns the type of employee (e.g., handler, vet). This must be implemented by subclasses.
     * 
     * @return the type of employee
     */
    public abstract String getType();

    /**
     * Adds a new responsibility (e.g., a habitat or species) to the employee's list of responsibilities.
     * 
     * @param id  the ID of the responsibility to add
     */
    public abstract void addNewResponsability(String id);

    /**
     * Constructs a string representing the employee's responsibilities.
     * If there are no responsibilities, an empty string is returned.
     * 
     * @return a string listing the employee's responsibilities, separated by commas
     */
    public String responsabilityString() {
        if (_responsability == null || _responsability.isEmpty()) {
            return ""; // Return an empty string if there are no responsibilities
        }
    
        // Initialize with the first responsibility
        String ans = "|" + _responsability.get(0);
    
        // Append the remaining responsibilities, separated by commas
        for (int i = 1; i < _responsability.size(); i++) {
            ans += "," + _responsability.get(i);
        }
    
        return ans;
    }

    /**
     * Returns a string representation of the employee, including their ID and name.
     * 
     * @return a string in the format "|ID|Name"
     */
    @Override
    public String toString() {
        return "|" + _id + "|" + _name;
    }
}
