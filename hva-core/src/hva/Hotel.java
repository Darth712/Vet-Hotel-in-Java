package hva;

import java.io.Serial;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import hva.exceptions.ImportFileException;
import hva.exceptions.UnrecognizedEntryException;
import hva.Seasons.*;
import hva.animal.*;
import hva.employee.*;
import hva.habitat.*;
import java.util.Map;
import java.util.List;



//FIXME import other Java classes
//FIXME import project classes

public class Hotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081733L;

    private Season _currentSeason;
    private Map<String,Habitat> _habitats;
    private Map<String,Species> _species;
    private Map<String,Handler> _handlers;
    private Map<String,Vet> _vets;
    private Map<String,Vaccine> _vaccines;
    private List<Vaccination> _vaccinations;
    /**
     * Read text input file and create domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    public void importFile(String name) throws ImportFileException {
    //  try {
            
    //      } catch (IOException | UnrecognizedEntryException /* FIXME maybe other exceptions */ e) {
    //          throw new ImportFileException(filename, e);
    //      }
    
    }
  
}
