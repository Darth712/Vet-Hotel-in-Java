package hva.visitor;

import hva.employee.Employee;
import hva.habitat.Habitat;
import hva.Vaccine;
import hva.animal.Animal;
import hva.Vaccination;
import java.io.Serializable;

public abstract class Visitor<T> implements Serializable{

    public abstract T visit(Animal animal);
    public abstract T visit(Employee employee);
    public abstract T visit(Habitat habitat);
    public abstract T visit(Vaccine vaccine);
    public abstract T visit(Vaccination vaccination);
}
