package hva.exceptions;

public class VaccineExistsException extends HotelException{

    private static final long serialVersionUID = 202407081735L;

    /** The Vaccine's key. */
    private final String _id;

    /** @param id */
    public VaccineExistsException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
        
}