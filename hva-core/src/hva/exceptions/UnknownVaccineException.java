package hva.exceptions;

public class UnknownVaccineException extends HotelException{

    private static final long serialVersionUID = 202407081710L;

    /** The Vaccine's key. */
    private final String _id;

    /** @param id */
    public UnknownVaccineException(String id) {
        _id = id;
    }

    /** @return the id */
    public String getId() {
        return _id;
    }

}
