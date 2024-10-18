package hva.exceptions;

public class HotelException extends Exception{

    private static final long serialVersionUID = 202407081733L;

    public HotelException() {
        super("(empty message)");
      }
    
      /** @param message */
      public HotelException(String message) {
        super(message);
      }    
    
}
