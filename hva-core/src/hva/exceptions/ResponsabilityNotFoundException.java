package hva.exceptions;

public class ResponsabilityNotFoundException extends HotelException{
    private static final long serialVersionUID = 202407081755L;

 
    private final String _id;

    /** @param id */
    public ResponsabilityNotFoundException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
}
