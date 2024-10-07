package hva;

import java.io.*;
import hva.exceptions.*;

//FIXME import other Java classes
//FIXME import other project classes

/**
 * Class that represents the hotel application.
 */
public class HotelManager {

    /** This is the current hotel. */
   
    private Hotel _hotel = new Hotel();
    private File _assosciatedFile = null;



    // FIXME maybe add more fields if needed

    /**
     * Saves the serialized application's state into the file associated to the current network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be created or opened.
     * @throws MissingFileAssociationException if the current network does not have a file.
     * @throws IOException if there is some error while serializing the state of the network to disk.
     */
    public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
        if (_assosciatedFile == null){
            throw new MissingFileAssociationException("No associated file to save");
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_assosciatedFile)));
            oos.writeObject(_hotel);
            oos.close();
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }

    /**
     * Saves the serialized application's state into the file associated to the current network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be created or opened.
     * @throws MissingFileAssociationException if the current network does not have a file.
     * @throws IOException if there is some error while serializing the state of the network to disk.
     */
    public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
        _assosciatedFile = new File(filename);
        save();
    }

    /**
     * @param filename name of the file containing the serialized application's state
     *        to load.
     * @throws UnavailableFileException if the specified file does not exist or there is
     *         an error while processing this file.
     */
    public void load(String filename) throws UnavailableFileException {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            _hotel = (Hotel) ois.readObject();  // Deserialize the hotel object
        } catch (FileNotFoundException e) {
            throw new UnavailableFileException("The file " + filename + " was not found.");
        } catch (IOException | ClassNotFoundException e) {
            throw new UnavailableFileException("Error processing the file " + filename + ": " + e.getMessage());
        }
    }
    /**
     * Read text input file.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    public void importFile(String filename) throws ImportFileException {
        _hotel.importFile(filename);
    }
    public Hotel getHotel() {return _hotel;}
}
