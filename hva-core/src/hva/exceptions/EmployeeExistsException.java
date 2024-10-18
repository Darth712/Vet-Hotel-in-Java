package hva.exceptions;

public class EmployeeExistsException extends HotelException{

    private static final long serialVersionUID = 202407081747L;
    
    /** The Habitat's key. */

    private final String _id;

    /** @param id */
    public EmployeeExistsException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
    
}
