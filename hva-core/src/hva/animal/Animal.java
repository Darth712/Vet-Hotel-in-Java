package hva.animal;

import java.io.Serializable;
import java.util.List;

import hva.Species;
import hva.habitat.Habitat;
import hva.Vaccination;

import java.util.ArrayList;


public class Animal implements Serializable{
    private String _id;
    private String _name;
    private Species _species;
    private String _healthStatus;
    private Habitat _habitat;
    private String _healthHistory;   // concatenar novas healhStatus para healthHistory
    private List<Vaccination> _vaccinations = new ArrayList<>();
    private boolean _hasVaccinated = false;
    // vaccinations


    public Animal(String id, String name, Species species, Habitat habitat) {
        _id = id;
        _name = name;
        _species = species;
        _habitat = habitat;
        
    }

    public String getHealthHistory() {
        return _healthHistory;
    }

    public List<Vaccination> getVaccinations() {
        return _vaccinations;
    }

    public void addHealthHistory(String entry) {
        if (_healthHistory == null) {
            _healthHistory = entry;
        }
        else {
            _healthHistory += "," + entry;
        }

    }

    public void addVaccination(Vaccination vaccination) {
        _vaccinations.add(vaccination);
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

    public void vaccinated() {_hasVaccinated = true;}


    @Override
    public String toString() {
        if (_hasVaccinated)
            return "ANIMAL|" + _id + "|" + _name +"|" +_species.getId()+"|"+_healthHistory+"|"+_habitat.getId();

        return "ANIMAL|" + _id + "|" + _name +"|" +_species.getId()+"|VOID|"+_habitat.getId();
    } 

    // public void _hasVaccinated  , -> true if vaccinated





    

}
