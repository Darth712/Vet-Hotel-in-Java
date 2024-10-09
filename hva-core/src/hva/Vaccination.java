package hva;

import java.io.Serializable;

import hva.animal.Animal;




public class Vaccination implements Serializable{

    private String _vaccineId;
    private String _vetId;
    private Animal _animal;

    public Vaccination(Vaccine vaccine, String vetId, Animal animal) {
        vaccine.use();
        animal.vaccinated();
        _vaccineId = vaccine.getId();
        _vetId = vetId;
        _animal = animal;


    }

    public String getId() {
        return _vaccineId;
    }

    public String getVet() {
        return _vetId;
    }

    public String getAnimal() {
        return _animal.getId();
    }


    @Override
    public String toString() {
        return "REGISTO_VACINA|" + _vaccineId +"|" + _vetId +"|" + _animal.getSpecies().getId();
        
    }
}
    