package hva.employee;

import java.util.ArrayList;

/**
 * Class representing a Handler, a type of employee responsible for habitats in the system.
 */
public class Handler extends Employee{

    /**
     * Constructs a new Handler with the specified ID and name.
     * 
     * @param id    the unique identifier for the handler
     * @param name  the name of the handler
     */
    public Handler(String id, String name) {
        super(id, name);
        _responsability = new ArrayList<String>(); // List of habitat IDs the handler is responsible for
    }

    /**
     * Adds a new responsibility to the handler's list of responsibilities.
     * 
     * @param id  the ID of the habitat to add as a responsibility
     */
    @Override
    public void addNewResponsability(String id) {
        _responsability.add(id);
    }

    /**
     * Returns the type of the employee, which in this case is "TRT" (probably an abbreviation for Handler/Tratador).
     * 
     * @return the string "TRT" representing the type of employee
     */
    @Override
    public String getType() {
        return "TRT";
    }

  
}
