package hva.visitor;

import hva.employee.*;
import hva.habitat.Habitat;
import hva.Vaccine;
import hva.animal.Animal;
import hva.Vaccination;
import java.io.Serializable;
import hva.tree.*;
/**
 * Abstract class representing a visitor in the Visitor design pattern.
 * This class defines the visit methods for various types in the system.
 * 
 * @param <T> the return type of the visitor methods
 */
public abstract class Visitor<T> implements Serializable{
    public abstract T visit(Animal animal);
    public abstract T visit(Vet vet);
    public abstract T visit(Tree tree);
    public abstract T visit(Handler handler);
    public abstract T visit(Habitat habitat);
    public abstract T visit(Vaccine vaccine);
    public abstract T visit(Vaccination vaccination);
}
