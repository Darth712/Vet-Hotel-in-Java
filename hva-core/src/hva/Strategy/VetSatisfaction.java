package hva.Strategy;

import hva.employee.Vet;

public class VetSatisfaction implements CalculateStrategy{

    private Vet _vet;

    public VetSatisfaction(Vet vet) {
        _vet = vet;
    }

    public double totalWork() {
        return _vet.getResponsibilities().values().stream()
        .mapToDouble(species -> species.getPopulation() / species.getVets().size()) 
        .sum(); 
    }
    
    public double calculate() {
        return 20 - totalWork();
    }
}
