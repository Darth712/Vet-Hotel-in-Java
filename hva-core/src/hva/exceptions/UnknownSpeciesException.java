package hva.exceptions;

public class UnknownSpeciesException extends HotelException{

    private static final long serialVersionUID = 202407081739L;

    /** The Animal's key. */
    private final String _id;

    /** @param id */
    public UnknownSpeciesException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }

    
}
