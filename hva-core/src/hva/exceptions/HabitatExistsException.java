package hva.exceptions;

public class HabitatExistsException extends HotelException{

    private static final long serialVersionUID = 202407071741L;
    
    /** The Habitat's key. */

    private final String _id;

    /** @param id */
    public HabitatExistsException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
       
}
