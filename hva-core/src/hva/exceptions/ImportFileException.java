package hva.exceptions;

import java.io.Serial;

public class ImportFileException extends Exception {

    @Serial
    private static final long serialVersionUID = 202407031713L;

    private static final String ERROR_MESSAGE = "Erro a processar ficheiro de import: ";

    public ImportFileException(String filename) {
        super(ERROR_MESSAGE + filename);
    }

    public ImportFileException(String filename, Exception cause) {
        super(ERROR_MESSAGE + filename, cause);
    }

}
