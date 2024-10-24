package hva.Strategy;
import hva.animal.*;

public class AnimalSatisfaction implements CalculateStrategy{

    private Animal _animal;

    /**
     * Constructor to initialize the AnimalSatisfaction with a specific animal.
     * 
     * @param animal The animal for which the satisfaction is calculated.
     */
    public AnimalSatisfaction(Animal animal) {
        _animal = animal;
    }

    /**
     * Calculates the number of animals in the habitat that are of the same species as the given animal.
     * 
     * @return The count of animals of the same species in the habitat.
     */
    public int sameSpeciesHabitat() {
        return (int) _animal.getHabitat().getAnimals().values().stream()
        .filter(animal -> animal.getSpecies().equals(_animal.getSpecies()))
        .count();
    }

    /**
     * Calculates the number of animals in the habitat that are of different species from the given animal.
     * 
     * @return The count of animals of different species in the habitat.
     */
    public int differentSpeciesHabitat() {
        return _animal.getHabitat().getAnimals().size() - sameSpeciesHabitat();
    }

    /**
     * Determines the adequacy of the habitat for the given animal based on species influence.
     * 
     * @return A score based on the adequacy (positive, negative, or neutral influence)
     */
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

    /**
     * Calculates the overall satisfaction score of the animal based on various factors:
     * - Number of same species in the habitat
     * - Number of different species in the habitat
     * - Habitat area per animal
     * - Habitat adequacy based on species influence
     * @return The satisfaction score as a double value.
     */
    public double calculate() {
        return 20 + 3*(sameSpeciesHabitat()-1) - 2*differentSpeciesHabitat() + (_animal.getHabitat().getArea()
        / _animal.getHabitat().getAnimals().size()) + adequacy();
    }
    
}
