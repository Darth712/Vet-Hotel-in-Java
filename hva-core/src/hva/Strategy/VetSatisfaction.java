package hva.Strategy;

import hva.employee.Vet;

public class VetSatisfaction implements CalculateStrategy{

    private Vet _vet;

    /**
     * Constructor to initialize the VetSatisfaction with a specific vet.
     * 
     * @param vet The vet for whom the satisfaction is calculated.
     */
    public VetSatisfaction(Vet vet) {
        _vet = vet;
    }

     /**
     * Calculates the total workload for the vet, distributing the population of each species
     * among the number of vets responsible for that species.
     * 
     * @return The total calculated workload for the vet.
     */
    public double totalWork() {
        return _vet.getResponsibilities().values().stream()
        .mapToDouble(species -> species.getPopulation() / species.getVets().size()) 
        .sum(); 
    }
    
    /**
     * Calculates the vet's satisfaction score based on the total workload.
     * The satisfaction score starts at 20 and decreases based on the workload.
     * 
     * @return The calculated satisfaction score.
     */
    public double calculate() {
        return 20 - totalWork();
    }
    
}
