package hva.employee.vet;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import hva.employee.Employee;

public class Vet extends Employee implements Serializable{

    private Map<String, Species> _responsability;
    
}
