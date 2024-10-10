package hva.app;

import hva.animal.Animal;
import hva.employee.Employee;
import hva.habitat.Habitat;
import hva.tree.Tree;
import hva.Vaccine;



import hva.Vaccination;
import hva.visitor.Visitor;

/**
 * Concrete implementation of the Visitor class, specifically for converting objects to their string representations.
 * This visitor traverses various object types (Animal, Employee, Habitat, Vaccine, Vaccination) and returns their
 * formatted string representations.
 */
public class ToStringVisitor extends Visitor<String>{

    /**
     * Visits an Animal object and returns a string representation of its details.
     * If the animal has been vaccinated, includes its health history; otherwise, includes "VOID".
     * 
     * @param animal the Animal object to visit
     * @return a formatted string representing the animal's details
     */
    @Override
    public String visit(Animal animal) {
        if (animal.hasVaccinated()) {
            return "ANIMAL|" + animal.getId() + "|" + animal.getName() + "|" + 
                   animal.getSpecies().getId() + "|" + animal.getHealthHistory() + 
                   "|" + animal.getHabitat().getId();
        }
        return "ANIMAL|" + animal.getId() + "|" + animal.getName() + "|" + 
               animal.getSpecies().getId() + "|VOID|" + animal.getHabitat().getId();
    }

    /**
     * Visits an Employee object and returns a string representation of its details
     * 
     * @param employee the Employee object to visit
     * @return a formatted string representing the employee's details
     */
    @Override
    public String visit(Employee employee) {
        return employee.getType() + "|" + employee.getId() + "|" + employee.getName() + employee.responsabilityString();
    }

    /**
     * Visits a Habitat object and returns a string representation of its details
     * 
     * @param habitat the Habitat object to visit
     * @return a formatted string representing the habitat's details
     */
    @Override
    public String visit(Habitat habitat) {
        StringBuilder habitatInfo = new StringBuilder("HABITAT|" + habitat.getId() + 
                                               "|" + habitat.getName() + 
                                               "|" + habitat.getArea() + 
                                               "|" + habitat.numOfTrees());
        
        if (!habitat.getTrees().isEmpty()) {
            habitatInfo.append("\n");
            for (Tree tree : habitat.getTrees().values()) {
                habitatInfo.append("ÁRVORE|" + tree.getId() + "|" + tree.getName() + 
                    "|" + tree.getAge() + "|" + tree.getBaseCleaningDifficulty() +
                    "|" + tree.getLeafType() + "|" + tree.getCurrentSeason().getDeciduousCycle()
                    ).append("\n");
            }
        }
        return habitatInfo.toString();
    }

    /**
     * Visits a Vaccine object and returns a string representation of its details
     * 
     * @param vaccine the Vaccine object to visit
     * @return a formatted string representing the vaccine's details
     */
    @Override
    public String visit(Vaccine vaccine) {
        return "VACINA|" + vaccine.getId() + "|" + vaccine.getName() + "|" + 
               vaccine.getTimesUsed() + vaccine.speciesString();
    }

    /**
     * Visits a Vaccination object and returns a string representation of its details
     * 
     * @param vaccination the Vaccination object to visit
     * @return a formatted string representing the vaccination's details
     */
    @Override
    public String visit(Vaccination vaccination) {
        return "REGISTO_VACINA|" + vaccination.getVaccineId() + "|" + vaccination.getVet() + 
               "|" + vaccination.getAnimal().getSpecies().getId();
    }
}
