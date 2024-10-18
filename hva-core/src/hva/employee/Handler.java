package hva.employee;


import java.util.TreeMap;
import hva.habitat.Habitat;
import hva.visitor.Visitor;

/**
 * Class representing a Handler, a type of employee responsible for habitats in the system.
 */
public class Handler extends Employee{

    private TreeMap<String,Habitat> _responsibilities;



    /**
     * Constructs a new Handler with the specified ID and name.
     * 
     * @param id    the unique identifier for the handler
     * @param name  the name of the handler
     */
    public Handler(String id, String name) {
        super(id, name);
        _responsibilities = new TreeMap<String,Habitat>(); // List of habitat IDs the handler is responsible for
    }

    /**
     * Adds a new responsibility to the handler's list of responsibilities.
     * 
     * @param id  the ID of the habitat to add as a responsibility
     */
  
    public void addNewResponsibility(String id, Habitat habitat) {
        _responsibilities.put(id, habitat);
    }

    public TreeMap<String,Habitat> getResponsibilities() {
        return _responsibilities;
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
