package hva.satisfaction;

import hva.employee.Vet;

public class VetSatisfaction implements SatisfactionStrategy{

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
