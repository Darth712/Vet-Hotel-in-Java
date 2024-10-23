package hva.vaccine;
import hva.Species;

import hva.animal.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VaccineDamage{

    Vaccine _vaccine;
    Animal _animal;

    public VaccineDamage(Vaccine vaccine, Animal animal) {
        _vaccine = vaccine;
        _animal = animal;
    }

    public int getLargestName(String species1, String species2) {
        return Math.max(species1.length(), species2.length());
    }

    static int countEqualChars(String species1, String species2) { 
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
 

    public int calculate() {
        int maxDamage = 0;

        // Iterate over the applicable species in the vaccine's TreeMap
        for (Map.Entry<String, Species> entry : _vaccine.getApplicableSpecies().entrySet()) {
            

            String speciesName = entry.getValue().getName(); // Get the species name

            if (speciesName.equals(_animal.getSpecies().getName()))
                return -1;

            // Calculate the largest name size difference
            int largestName = getLargestName(_animal.getSpecies().getName(), speciesName);

            // Calculate the number of common characters
            int commonChars = countEqualChars(_animal.getSpecies().getName(), speciesName);

            // Calculate new damage as largest name size minus common characters
            int newDamage = largestName - commonChars;

            // Update maxDamage if this one is larger
            if (newDamage > maxDamage) {
                maxDamage = newDamage;
            }
        }

        return maxDamage;
    }

    public String getNewHealthStatus(int damage) {

        if (damage == 0) {
            return "CONFUSAO";
        } else if (damage >= 1 && damage <= 4) {
            return "ACIDENTE";
        } else if (damage >= 5) {
            return "ERRO";
        }
        
        return "NORMAL";
        
    }
}
