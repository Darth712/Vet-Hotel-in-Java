package hva.animal;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import hva.Species;
import hva.habitat.Habitat;
import hva.visitor.*;
import hva.Vaccination;


/**
 * Represents an animal in the system, with attributes such as species, health status,
 * vaccinations, and habitat.
 */
public class Animal implements Serializable, Visitable{

    @Serial
    private static final long serialVersionUID = 202407081734L;

    private String _id;                                           // Animal ID
    private String _name;                                         // Animal name
    private Species _species;                                     // Animal species
    private String _healthStatus;                                 // Current health status
    private Habitat _habitat;                                     // Animal habitat
    private String _healthHistory;                                // Health status history
    private List<Vaccination> _vaccinations = new ArrayList<>();  // List of vaccinations
    private boolean _hasVaccinated = false;                       // Vaccination status

    /**
     * Constructs a new Animal with the specified ID, name, species, and habitat.
     * 
     * @param id       the unique identifier for the animal
     * @param name     the name of the animal
     * @param species  the species of the animal
     * @param habitat  the habitat where the animal resides
     */
    public Animal(String id, String name, Species species, Habitat habitat) {
        _id = id;
        _name = name;
        _species = species;
        _habitat = habitat;
    }

    /**
     * Retrieves the animal's health history.
     * 
     * @return the health history of the animal
     */
    public String getHealthHistory() {
        return _healthHistory;
    }

    /**
     * Retrieves the list of vaccinations the animal has received.
     * 
     * @return the list of vaccinations
     */
    public List<Vaccination> getVaccinations() {
        return _vaccinations;
    }

    /**
     * Adds a new entry to the animal's health history.
     * 
     * @param entry the new health status to add to the history
     */
    public void addHealthHistory(String entry) {
        if (_healthHistory == null) {
            _healthHistory = entry;  // Initialize history if it is null
        } else {
            _healthHistory += "," + entry;  // Append new entry to existing history
        }
    }

    /**
     * Adds a new vaccination to the animal's vaccination record.
     * 
     * @param vaccination the vaccination to add
     */
    public void addVaccination(Vaccination vaccination) {
        _vaccinations.add(vaccination);  // Adds the vaccination to the list
    }

    /**
     * Retrieves the animal's unique ID.
     * 
     * @return the ID of the animal
     */
    public String getId() {
        return _id;
    }

    /**
     * Retrieves the name of the animal.
     * 
     * @return the name of the animal
     */
    public String getName() {
        return _name;
    }

    /**
     * Retrieves the species of the animal.
     * 
     * @return the species of the animal
     */
    public Species getSpecies() {
        return _species;
    }

    /**
     * Retrieves the current health status of the animal.
     * 
     * @return the current health status
     */
    public String getHealthStatus() {
        return _healthStatus;
    }

    /**
     * Retrieves the habitat where the animal resides.
     * 
     * @return the habitat of the animal
     */
    public Habitat getHabitat() {
        return _habitat;
    }

    /**
     * Sets the health status of the animal.
     * 
     * @param status the new health status of the animal
     */
    public void setHealthStatus(String status) {
        _healthStatus = status;
    }

    /**
     * Sets the habitat of the animal.
     * 
     * @param habitat the new habitat for the animal
     */
    public void setHabitat(Habitat habitat) {
        _habitat = habitat;
    }

    /**
     * Marks the animal as vaccinated.
     */
    public void vaccinated() {
        _hasVaccinated = true;
    }

    /**
     * Checks if the animal has been vaccinated
     * 
     * @return boolean
     */
    public boolean hasVaccinated() {
        return _hasVaccinated;
    }

  

    // public void _hasVaccinated  , -> true if vaccinated  TO-DO

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


