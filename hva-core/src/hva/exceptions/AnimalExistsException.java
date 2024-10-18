package hva.exceptions;

public class AnimalExistsException extends HotelException{

    private static final long serialVersionUID = 202407081735L;

    /** The Animal's key. */
    private final String _id;

    /** @param id */
    public AnimalExistsException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
        
}
