package hva.satisfaction;

import hva.employee.*;
import hva.habitat.Habitat;
import hva.tree.Tree;

public class HandlerSatisfaction implements SatisfactionStrategy{

    private Handler _handler;


    public HandlerSatisfaction(Handler handler) {
        _handler = handler;
    }

    public double habitatWork(Habitat habitat) {

        double totalCleaningEffort = habitat.getTrees().values().stream()
        .mapToInt(Tree::getBaseCleaningDifficulty) 
        .sum();

        
        return habitat.getArea() + 3 * habitat.getAnimals().size() + totalCleaningEffort;
    }


    public double totalWork() {
        return _handler.getResponsibilities().values().stream()
            .mapToDouble(habitat -> habitatWork(habitat) / habitat.getHandlers().size()) 
            .sum(); 
    }

    public double calculate() {
        return 300 - totalWork();
    }
    

    
}
