package hva.employee;

import hva.Species;
import hva.visitor.Visitor;
import java.util.TreeMap;

/**
 * Class representing a Veterinarian (Vet), a type of employee responsible for species in the system.
 */
public class Vet extends Employee{
    
    private TreeMap<String,Species> _responsibilities; // Map of responsabilities

    /**
     * Constructs a new Vet with the specified ID and name.
     * 
     * @param id    the unique identifier for the vet
     * @param name  the name of the vet
     */
    public Vet(String id, String name) {
        super(id, name);
        _responsibilities = new TreeMap<String,Species>(); 
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
    
    public void addNewResponsibility(String id, Species species) {
        _responsibilities.put(id, species);
    }

    public TreeMap<String,Species> getResponsibilities() {
        return _responsibilities;
    }



    /**
     * Returns the type of the employee, which in this case is "VET".
     * 
     * @return the string "VET" representing the type of employee
     */
    @Override
    public String getType() {
        return "VET";
    }

    /**
     * Accepts a visitor and allows it to perform operations on this instance.
     * Part of the Visitor design pattern.
     * 
     * @param <T> the type of the result produced by the visitor
     * @param visitor the visitor performing the operation
     * @return the result of the visitor's operation, String
     */
    @Override
    public <T> T accept(Visitor<T> visitor) {
      return visitor.visit(this);
    }
}
