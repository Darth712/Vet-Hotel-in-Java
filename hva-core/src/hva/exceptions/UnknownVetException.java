package hva.exceptions;

public class UnknownVetException extends HotelException {
    private static final long serialVersionUID = 202407081709L;

    /** The Vet's key. */
    private final String _id;

    /** @param id */
    public UnknownVetException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }
}
