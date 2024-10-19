package hva.exceptions;

public class UnknownEmployeeException extends HotelException{

    private static final long serialVersionUID = 202407081753L;
    


    private final String _id;

    /** @param id */
    public UnknownEmployeeException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
    
}
