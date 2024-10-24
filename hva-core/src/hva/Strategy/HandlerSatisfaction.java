package hva.Strategy;

import hva.employee.*;
import hva.habitat.Habitat;
import hva.tree.Tree;

public class HandlerSatisfaction implements CalculateStrategy {

    private Handler _handler;

    /**
     * Constructor to initialize the HandlerSatisfaction with a specific handler.
     * 
     * @param handler The handler for whom the satisfaction is calculated.
     */
    public HandlerSatisfaction(Handler handler) {
        _handler = handler;
    }

    /**
     * Calculates the work effort required for a specific habitat based on its area, 
     * number of animals, and total cleaning effort for its trees.
     * 
     * @param habitat The habitat assigned to the handler.
     * @return The calculated work effort for the habitat.
     */
    public double habitatWork(Habitat habitat) {

        double totalCleaningEffort = habitat.getTrees().values().stream()
        .mapToDouble(Tree::getCleaningEffort)
        .sum();

        return habitat.getArea() + 3 * habitat.getAnimals().size() + totalCleaningEffort;
    }

    /**
     * Calculates the total work effort for all habitats assigned to the handler, 
     * distributing the workload among multiple handlers for each habitat.
     * 
     * @return The total calculated workload for the handler.
     */
    public double totalWork() {
        return _handler.getResponsibilities().values().stream()
            .mapToDouble(habitat -> habitatWork(habitat) / habitat.getHandlers().size())
            .sum();
    }

    /**
     * Calculates the handler's satisfaction score based on the total workload. 
     * The satisfaction score starts at 300 and decreases based on the workload.
     * 
     * @return The calculated satisfaction score.
     */
    public double calculate() {
        return 300 - totalWork();
    }

}

