package hva;

import java.io.Serializable;
import hva.employee.Vet;

public class Vaccination implements Serializable{
    private String _id;
    private String _date;
    private Vet _vet;

    public Vaccination(String id, String date, Vet vet) {
        _id = id;
        _date = date;
        _vet = vet;
    }

    public String getId() {
        return _id;
    }

    public String getDate() {
        return _date;
    }

    public Vet getVet() {
        return _vet;
    }
}
