package hva;

import java.io.Serial;
import java.io.Serializable;
import hva.animal.Animal;
import hva.vaccine.Vaccine;
import hva.visitor.*;

/**
 * Class representing a vaccination record for an animal.
 * Implements Serializable for object serialization.
 */
public class Vaccination implements Serializable, Visitable{


    @Serial
    private static final long serialVersionUID = 202407081739L;

    private String _vaccineId;  // Identifier for the vaccine
    private String _vetId;      // Identifier for the veterinarian administering the vaccine
    private Animal _animal;     // The animal that received the vaccination
    private int _damage;

    /**
     * Constructor for the Vaccination class.
     *
     * @param vaccine The vaccine used for the vaccination.
     * @param vetId   The ID of the veterinarian administering the vaccination.
     * @param animal  The animal receiving the vaccination.
     * @param damage  The damage that was applied by this vaccination.
     */
    public Vaccination(Vaccine vaccine, String vetId, Animal animal, int damage) {
        vaccine.use();                // Mark the vaccine as used
        animal.vaccinated();          // Mark the animal as vaccinated
        _vaccineId = vaccine.getId(); // Set the vaccine ID
        _vetId = vetId;               // Set the veterinarian ID
        _animal = animal;             // Set the animal
        _damage = damage;
    }

    /**
     * Gets the ID of the vaccine.
     *
     * @return The ID of the vaccine.
     */
    public String getVaccineId() {
        return _vaccineId;            // Return the vaccine ID
    }

    /**
     * Gets the ID of the veterinarian.
     *
     * @return The ID of the veterinarian.
     */
    public String getVet() {
        return _vetId;                // Return the veterinarian ID
    }

    /**
     * Gets the ID of the animal that received the vaccination.
     *
     * @return The ID of the animal.
     */
    public Animal getAnimal() {
        return _animal;       // Return the animal ID
    }

    /**
     * Gets the damage taken by the animal.
     *
     * @return The damage of the vaccination.
     */
    public int getDamage() {
        return _damage;      
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
