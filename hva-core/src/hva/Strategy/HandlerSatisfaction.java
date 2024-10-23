package hva.Strategy;

import hva.employee.*;
import hva.habitat.Habitat;
import hva.tree.Tree;

public class HandlerSatisfaction implements CalculateStrategy{

    private Handler _handler;


    public HandlerSatisfaction(Handler handler) {
        _handler = handler;
    }

    public double habitatWork(Habitat habitat) {

        double totalCleaningEffort = habitat.getTrees().values().stream()
        .mapToInt(Tree::getBaseCleaningDifficulty) 
        .sum();   // está mal, esforço limpeza != limpezaBase

        
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
