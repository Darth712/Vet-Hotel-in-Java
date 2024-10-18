package hva.exceptions;

public class TreeExistsException extends HotelException{

    private static final long serialVersionUID = 202407081745L;
    
    /** The Habitat's key. */

    private final String _id;

    /** @param id */
    public TreeExistsException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
    
}
