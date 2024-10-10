
package hva.app;

import hva.animal.Animal;
import hva.employee.Employee;
import hva.habitat.Habitat;
import hva.tree.Tree;
import hva.Vaccine;



import hva.Vaccination;
import hva.visitor.Visitor;

public class ToStringVisitor extends Visitor<String>{

    /**
     * Returns a string representation of the Handler, including its type, ID, name, and responsibilities.
     * 
     * @return a formatted string representing the handler's details and responsibilities
     */
    @Override
    public String visit(Animal animal) {
        if (animal.hasVaccinated())
            return 
                    "ANIMAL|" + animal.getId()+ "|" + animal.getName() + "|" +
                    animal.getSpecies().getId() + "|" + animal.getHealthHistory() + "|" + animal.getHabitat().getId();
        
        return 
                "ANIMAL|" + animal.getId() + "|" + animal.getName() + "|" + animal.getSpecies().getId() + 
                "|VOID|" + animal.getHabitat().getId();

    }

    @Override
    public String visit(Employee employee) {
        return employee.getType() + "|" + employee.getId() + "|" + employee.getName() + "|" + employee.responsabilityString();
    }

    @Override
    public String visit(Habitat habitat) {
        StringBuilder habitatInfo = new StringBuilder("HABITAT|" + habitat.getId() + 
                                               "|" + habitat.getName() + 
                                                "|" + habitat.getArea());
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


    @Override
    public String visit(Vaccine vaccine) {
        return "VACINA|" + vaccine.getId() + "|" + vaccine.getName() + "|" + 
                vaccine.getTimesUsed() + vaccine.speciesString();
    }

    @Override
    public String visit(Vaccination vaccination) {
        return "REGISTO_VACINA|" + vaccination.getVaccineId() + "|" + vaccination.getVet() + 
                "|" + vaccination.getAnimal().getSpecies().getId();
    }
}
