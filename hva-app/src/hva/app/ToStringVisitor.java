package hva.app;

import hva.animal.Animal;

import hva.employee.Handler;
import hva.employee.Vet;
import hva.habitat.Habitat;

import hva.Vaccine;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import hva.Vaccination;
import hva.visitor.Visitor;

/**
 * Concrete implementation of the Visitor class, 
 * specifically for converting objects to their string representations.
 * This visitor traverses various object types (Animal, Employee, Habitat, Vaccine, Vaccination) 
 * and returns their formatted string representations.
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

     /*
      * 
    public String visit(Employee employee) {
        StringBuilder employeeInfo = new StringBuilder(
            employee.getType() + "|" + employee.getId() + "|" + 
        employee.getName());

              
    }

      */
    @Override
    public String visit(Handler handler) {
        StringBuilder handlerInfo = new StringBuilder(
            handler.getType() + "|" + handler.getId() + "|" + 
        handler.getName());
        if(!handler.getResponsibilities().isEmpty()) {
            StringJoiner resInfo = new StringJoiner(",");
            handler.getResponsibilities().forEach((id, species) -> {
                resInfo.add(id);
            });

            handlerInfo.append("|").append(resInfo.toString());
        }   
        return handlerInfo.toString();  // Return the full string
    }

    @Override
    public String visit(Vet vet) {
        StringBuilder vetInfo = new StringBuilder(
            vet.getType() + "|" + vet.getId() + "|" + 
        vet.getName());

        if(!vet.getResponsibilities().isEmpty()) {
            StringJoiner resInfo = new StringJoiner(",");
            vet.getResponsibilities().forEach((id, species) -> {
                resInfo.add(id);
            });

            vetInfo.append("|").append(resInfo.toString());
        }    
        return vetInfo.toString();  // Return the full string
    }

    /**
     * Visits a Habitat object and returns a string representation of its details
     * 
     * @param habitat the Habitat object to visit
     * @return a formatted string representing the habitat's details
     */
    @Override
    public String visit(Habitat habitat) {
        StringBuilder habitatInfo = new StringBuilder
        ("HABITAT|" + habitat.getId() + 
         "|" + habitat.getName() + 
         "|" + habitat.getArea() + 
         "|" + habitat.numOfTrees());
        
         if (!habitat.getTrees().isEmpty()) {
            habitatInfo.append("\n");
            
            // Use String.join() to join each tree info with "\n"
            habitatInfo.append(habitat.getTrees().values().stream()
                .map(tree -> "ÁRVORE|" + tree.getId() + "|" + tree.getName() + 
                    "|" + tree.getAge() + "|" + tree.getBaseCleaningDifficulty() +
                    "|" + tree.getLeafType() + "|" + tree.getCurrentSeason().getDeciduousCycle())
                .collect(Collectors.joining("\n")));
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
        StringBuilder vaccineInfo = new StringBuilder
        ("VACINA|" + vaccine.getId() + 
         "|" + vaccine.getName() + 
         "|" + vaccine.getTimesUsed());

        
        if (!vaccine.getApplicableSpecies().isEmpty()) {
            StringJoiner applicableSpecies = new StringJoiner(",");
            vaccine.getApplicableSpecies().forEach((id, species) -> {
                applicableSpecies.add(id);
            });

            vaccineInfo.append("|").append(applicableSpecies.toString());
        }

         return vaccineInfo.toString();

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
