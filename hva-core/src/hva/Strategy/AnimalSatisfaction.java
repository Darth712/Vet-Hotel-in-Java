package hva.Strategy;
import hva.animal.*;

public class AnimalSatisfaction implements CalculateStrategy{

    private Animal _animal;

    public AnimalSatisfaction(Animal animal) {
        _animal = animal;
    }

    public int sameSpeciesHabitat() {
        return (int) _animal.getHabitat().getAnimals().values().stream()
        .filter(animal -> animal.getSpecies().equals(_animal.getSpecies()))
        .count();
    }

    public int differentSpeciesHabitat() {
        return _animal.getHabitat().getAnimals().size() - sameSpeciesHabitat();
    }

    public int adequacy() {
        
        String adeq = _animal.getHabitat().getInfluence().get(_animal.getSpecies().getId());

        if (adeq == null) {
            return 0;
        }

        if(adeq.equals("POS"))
            return 20;
        if(adeq.equals("NEG"))
            return -20;
        return 0;
    }

    public double calculate() {
        return 20 + 3*(sameSpeciesHabitat()-1) - 2*differentSpeciesHabitat() + (_animal.getHabitat().getArea()
        / _animal.getHabitat().getAnimals().size()) + adequacy();
    }
    
}
