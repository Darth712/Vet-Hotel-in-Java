package hva.employee;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import hva.employee.Employee;
import hva.Species;

public class Vet extends Employee implements Serializable{

    private Map<String, Species> _responsability;
    
}
