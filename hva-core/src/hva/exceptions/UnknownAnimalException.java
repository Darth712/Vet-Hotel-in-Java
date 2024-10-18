package hva.exceptions;

public class UnknownAnimalException extends HotelException{

    private static final long serialVersionUID = 202407081743L;
    
    /** The Habitat's key. */

    private final String _id;

    /** @param id */
    public UnknownAnimalException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
       
    
}
