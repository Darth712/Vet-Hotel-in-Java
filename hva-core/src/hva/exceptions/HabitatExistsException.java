package hva.exceptions;

public class HabitatExistsException {
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
