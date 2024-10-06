package hva;

import java.io.Serializable;

public class Species implements Serializable{

    private String _id;
    private String _name;

    public Species(String id, String name) {
        _id = id;
        _name = name;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }


    
}
