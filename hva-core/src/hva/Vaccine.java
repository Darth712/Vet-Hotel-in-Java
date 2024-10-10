package hva;

import java.io.Serial;
import java.io.Serializable;
import hva.visitor.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Class representing a vaccine used for animals.
 * Implements Serializable for object serialization.
 */
public class Vaccine implements Serializable, Visitable{

    @Serial
    private static final long serialVersionUID = 202407081740L;

    private String _id;                     // Identifier for the vaccine
    private String _name;                   // Name of the vaccine
    private int _timesUsed;                 // Number of times the vaccine has been used
    private List<Species> _applicableSpecies; // List of species applicable for the vaccine

    /**
     * Constructor for the Vaccine class.
     *
     * @param id   The ID of the vaccine.
     * @param name The name of the vaccine.
     */
    public Vaccine(String id, String name) {
        _id = id;
        _name = name;
        _timesUsed = 0;
        _applicableSpecies = new ArrayList<Species>();
    }

    /**
     * Adds a species to the list of species that can receive this vaccine.
     *
     * @param applicableSpecies The species to add to the list of applicable species.
     */
    public void addSpecies(Species applicableSpecies) {
        _applicableSpecies.add(applicableSpecies);
    }

    /**
     * Gets the ID of the vaccine.
     *
     * @return The ID of the vaccine.
     */
    public String getId() {
        return _id; // Return the vaccine ID
    }

    /**
     * Gets the name of the vaccine.
     *
     * @return The name of the vaccine.
     */
    public String getName() {
        return _name; // Return the vaccine name
    }

    /**
     * Marks the vaccine as used, incrementing the usage count.
     */
    public void use() {
        _timesUsed++; // Increment the usage count
    }

    /**
     * Gets the number of times the vaccine has been used.
     *
     * @return The number of times the vaccine has been used.
     */
    public int getTimesUsed() {
        return _timesUsed; // Return the times used
    }

    /**
     * Returns a string representation of the applicable species IDs.
     *
     * @return A string of applicable species IDs, formatted as "|id1,id2,id3".
     */
    public String speciesString() {
        if (_applicableSpecies == null || _applicableSpecies.isEmpty()) {
            return ""; // Return empty string if the list is empty or null
        }

        // Initialize ans with the first element
        String ans = "|" + _applicableSpecies.get(0).getId();

        // Loop through the rest of the list starting from index 1
        for (int i = 1; i < _applicableSpecies.size(); i++) {
            ans += "," + _applicableSpecies.get(i).getId();
        }

        return ans; // Return the formatted string
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
