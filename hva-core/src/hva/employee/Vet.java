package hva.employee;

import java.util.ArrayList;

/**
 * Class representing a Veterinarian (Vet), a type of employee responsible for species in the system.
 */
public class Vet extends Employee {

    /**
     * Constructs a new Vet with the specified ID and name.
     * 
     * @param id    the unique identifier for the vet
     * @param name  the name of the vet
     */
    public Vet(String id, String name) {
        super(id, name);
        _responsability = new ArrayList<String>(); // List of species IDs the vet is responsible for
    }

    /**
     * Retrieves the name of the vet.
     * 
     * @return the vet's name
     */
    public String getName() {
        return super.getName();
    }

    /**
     * Retrieves the unique ID of the vet.
     * 
     * @return the vet's ID
     */
    public String getId() {
        return super.getId();
    }

    /**
     * Adds a new responsibility to the vet's list of responsibilities.
     * 
     * @param id  the ID of the species to add as a responsibility
     */
    @Override
    public void addNewResponsability(String id) {
        _responsability.add(id);
    }

    /**
     * Returns the type of the employee, which in this case is "VET" (representing Veterinarian).
     * 
     * @return the string "VET" representing the type of employee
     */
    @Override
    public String getType() {
        return "VET";
    }

    /**
     * Returns a string representation of the Vet, including its type, ID, name, and responsibilities.
     * 
     * @return a formatted string representing the vet's details and responsibilities
     */
    @Override
    public String toString() {
        return this.getType() + super.toString() + this.responsabilityString();
    }
}
