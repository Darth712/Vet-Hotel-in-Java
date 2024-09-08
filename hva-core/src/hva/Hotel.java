package hva;

import java.io.Serial;
import java.io.Serializable;

//FIXME import other Java classes
//FIXME import project classes

public class Hotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081733L;

    //FIXME define attributes
    //FIXME define constructor(s)
    //FIXME define methods

    /**
     * Read text input file and create domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    void importFile(String filename) throws ImportFileException {
	try {
            // FIXME open import file and create the associated objects
	    // ....
        } catch (IOException | UnrecognizedEntryException /* FIXME maybe other exceptions */ e) {
            throw new ImportFileException(filename, e);
        }
    }

}
