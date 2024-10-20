package hva.exceptions;

public class VetNotAuthException extends HotelException {
    private static final long serialVersionUID = 202407081739L;

    /** The Animal's key. */
    private final String _vetId;
    private final String _speciesId;

    
    public VetNotAuthException(String vetId,String speciesId) {
        _vetId = vetId;
        _speciesId = speciesId;
    }

    /** @return the vet id */
    public String getVetId() {
        return _vetId;
    }

    /** @return the species id */
    public String getSpeciesId() {
        return _speciesId;
    }

}
