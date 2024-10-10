package hva;

import java.io.Serial;
import java.io.Serializable;
import hva.animal.Animal;

/**
 * Class representing a vaccination record for an animal.
 * Implements Serializable for object serialization.
 */
public class Vaccination implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081739L;

    private String _vaccineId;  // Identifier for the vaccine
    private String _vetId;      // Identifier for the veterinarian administering the vaccine
    private Animal _animal;     // The animal that received the vaccination

    /**
     * Constructor for the Vaccination class.
     *
     * @param vaccine The vaccine used for the vaccination.
     * @param vetId   The ID of the veterinarian administering the vaccination.
     * @param animal  The animal receiving the vaccination.
     */
    public Vaccination(Vaccine vaccine, String vetId, Animal animal) {
        vaccine.use();                // Mark the vaccine as used
        animal.vaccinated();          // Mark the animal as vaccinated
        _vaccineId = vaccine.getId(); // Set the vaccine ID
        _vetId = vetId;               // Set the veterinarian ID
        _animal = animal;             // Set the animal
    }

    /**
     * Gets the ID of the vaccine.
     *
     * @return The ID of the vaccine.
     */
    public String getId() {
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
    public String getAnimal() {
        return _animal.getId();       // Return the animal ID
    }

    @Override
    public String toString() {
        return "REGISTO_VACINA|" + _vaccineId + "|" + _vetId + "|" + _animal.getSpecies().getId();
        // Return a string representation of the vaccination record
    }
}
