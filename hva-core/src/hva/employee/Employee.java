package hva.employee;

import java.io.Serial;
import java.io.Serializable;
import hva.visitor.*;

/**
 * Abstract class representing an employee in the system.
 * This class is meant to be extended by specific types of employees.
 */
public abstract class Employee implements Serializable, Visitable{

    @Serial
    private static final long serialVersionUID = 202407081735L;

    private String _id;    // Employee ID
    private String _name;  // Employee name

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

}
