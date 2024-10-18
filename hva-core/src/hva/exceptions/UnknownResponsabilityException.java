package hva.exceptions;

public class UnknownResponsabilityException extends HotelException{

    private static final long serialVersionUID = 202407081749L;
    
    /** The Habitat's key. */

    private final String _id;

    /** @param id */
    public UnknownResponsabilityException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
    
}
