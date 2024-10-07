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
    private String _associatedFile = "";



    // FIXME maybe add more fields if needed

    /**
     * Saves the serialized application's state into the file associated to the current network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be created or opened.
     * @throws MissingFileAssociationException if the current network does not have a file.
     * @throws IOException if there is some error while serializing the state of the network to disk.
     */
    public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
        if (_associatedFile.isBlank()) throw new MissingFileAssociationException();
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_associatedFile)));
            oos.writeObject(_hotel);
            _hotel.setChanged(false);
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
        _associatedFile = filename;
        save();
    }

    /**
     * @param filename name of the file containing the serialized application's state
     *        to load.
     * @throws UnavailableFileException if the specified file does not exist or there is
     *         an error while processing this file.
     */
    public void load(String filename) throws UnavailableFileException {
        _associatedFile = filename;
        if (filename == null || filename.equals("")) throw new UnavailableFileException(filename);

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            _hotel = (Hotel) ois.readObject();
            _hotel.setChanged(false); // Deserialize the hotel object
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

    public String getFilename() { return _associatedFile;}
    public void setFilename(String filename) { _associatedFile = filename;}
    public Hotel getHotel() {return _hotel;}
    public boolean changed() {return _hotel.hasChanged();}

    public void reset() {
        _hotel = new Hotel();
        _associatedFile = null;
    }
}
