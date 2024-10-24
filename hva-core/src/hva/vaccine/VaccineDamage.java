package hva.vaccine;

import hva.Species;
import hva.animal.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VaccineDamage{

    Vaccine _vaccine;
    Animal _animal;

     /**
     * Constructor to initialize the VaccineDamage with a specific vaccine and animal.
     * 
     * @param vaccine The vaccine to assess.
     * @param animal The animal receiving the vaccine.
     */
    public VaccineDamage(Vaccine vaccine, Animal animal) {
        _vaccine = vaccine;
        _animal = animal;
    }

    /**
     * Compares the length of two species names and returns the length of the longer name.
     * 
     * @param species1 The first species name.
     * @param species2 The second species name.
     * @return The length of the longest species name.
     */
    public int getLargestName(String species1, String species2) {
        return Math.max(species1.length(), species2.length());
    }

    /**
     * Counts the number of common characters between two species names.
     * 
     * @param species1 The first species name.
     * @param species2 The second species name.
     * @return The number of characters common to both species names.
     */
    public int countEqualChars(String species1, String species2) { 
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();

        for(char c : species1.toCharArray()) {
            set1.add(c);
        }
        for(char c : species2.toCharArray()) {
            set2.add(c);
        }

        set1.retainAll(set2);

        return set1.size();
    }
 
    /**
     * Calculates the vaccine damage for the animal by comparing its species 
     * with the applicable species in the vaccine's list.
     * 
     * @return The calculated damage value, or -1 if the species matches exactly.
     */
    public int calculate() {
        int maxDamage = 0;

        for (Map.Entry<String, Species> entry : _vaccine.getApplicableSpecies().entrySet()) {
            String speciesName = entry.getValue().getName(); 

            if (speciesName.equals(_animal.getSpecies().getName()))
                return -1;

            int largestName = getLargestName(_animal.getSpecies().getName(), speciesName);
            int commonChars = countEqualChars(_animal.getSpecies().getName(), speciesName);
            int newDamage = largestName - commonChars;

            if (newDamage > maxDamage) {
                maxDamage = newDamage;
            }
        }

        return maxDamage;
    }

    /**
     * Determines the new health status of the animal based on the calculated damage.
     * 
     * @param damage The damage value calculated by the vaccine.
     * @return The corresponding health status based on damage level.
     */
    public String getNewHealthStatus(int damage) {

        if (damage == 0) {
            return "CONFUSÃO";
        } else if (damage >= 1 && damage <= 4) {
            return "ACIDENTE";
        } else if (damage >= 5) {
            return "ERRO";
        }
        
        return "NORMAL";
        
    }
}
