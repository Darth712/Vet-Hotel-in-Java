package hva.animal;

import java.io.Serializable;
import java.util.List;

import hva.Species;
import hva.habitat.Habitat;

public class Animal implements Serializable{

    private String _id;
    private String _name;   
    private Species _species;
    private String _healthStatus;
    private Habitat _habitat;
    private List<String> _healthHistory;
    private boolean _hasVaccinated = false;
    // vaccinations

    public Animal(String id, String name, Species species, Habitat habitat) {
        _id = id;
        _name = name;
        _species = species;
        _habitat = habitat;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public Species getSpecies() {
        return _species;
    }

    public String getHealthStatus() {
        return _healthStatus;
    }

    public Habitat getHabitat() {
        return _habitat;
    }

    

    public void setHealthStatus(String status) {
        _healthStatus = status;
    }

    public void setHabitat(Habitat habitat) {
        _habitat = habitat;
    }

    public void updateHealthHistory(String status) {
        _healthHistory.add(status);
    }

    // public void _hasVaccinated  , -> true if vaccinated





    

}
