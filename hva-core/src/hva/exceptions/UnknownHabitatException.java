package hva.exceptions;

public class UnknownHabitatException extends HotelException{

    private static final long serialVersionUID = 202407081733L;

    /** The Animal's key. */
    private final String _id;

    /** @param id */
    public UnknownHabitatException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
    
}
