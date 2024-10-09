package hva;

import java.io.*;
import hva.exceptions.*;

/**
 * Class that represents the hotel management application. Handles the saving,
 * loading, and importing of hotel data.
 */
public class HotelManager {

    /** This is the current hotel being managed by the application. */
    private Hotel _hotel = new Hotel();
    
    /** The file associated with the current state of the hotel. */
    private String _associatedFile = "";


    /**
     * Saves the serialized application's state into the file associated with the current hotel.
     * 
     * @throws FileNotFoundException if the file cannot be created or opened.
     * @throws MissingFileAssociationException if no file is associated with the current hotel.
     * @throws IOException if an error occurs while serializing the hotel's state to disk.
     */
    public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
        if (_associatedFile.isBlank()) throw new MissingFileAssociationException(); // Ensure the file is associated
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_associatedFile)));
            oos.writeObject(_hotel);  // Serialize the hotel object
            _hotel.setChanged(false);  // Mark hotel as not changed after save
            oos.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();  // Handle missing file exception
        }
        catch (IOException e) {
            e.printStackTrace();  // Handle IO exceptions during save
        }
    }

    /**
     * Saves the serialized application's state to a specified file, and associates 
     * that file with the current hotel.
     *
     * @param filename the name of the file to save the hotel state into
     * @throws FileNotFoundException if the file cannot be created or opened.
     * @throws MissingFileAssociationException if no file is associated with the current hotel.
     * @throws IOException if an error occurs while serializing the hotel's state to disk.
     */
    public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
        _associatedFile = filename;  // Associate the new file with the hotel
        save();  // Call save to write the hotel state to the new file
    }

    /**
     * Loads the serialized hotel's state from the specified file.
     * 
     * @param filename the name of the file containing the serialized hotel's state
     * @throws UnavailableFileException if the specified file does not exist or an error occurs during processing.
     */
    public void load(String filename) throws UnavailableFileException {
        _associatedFile = filename;  // Set the associated file
        if (filename == null || filename.equals("")) throw new UnavailableFileException(filename);  // Check for invalid filename

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            _hotel = (Hotel) ois.readObject();  // Deserialize and load the hotel object
            _hotel.setChanged(false);  // Mark hotel as unchanged after load
        } catch (FileNotFoundException e) {
            throw new UnavailableFileException("The file " + filename + " was not found.");  // Handle file not found
        } catch (IOException | ClassNotFoundException e) {
            throw new UnavailableFileException("Error processing the file " + filename + ": " + e.getMessage());  // Handle other IO or class errors
        }
    }

    /**
     * Imports data from a text file into the hotel system.
     *
     * @param filename the name of the text input file
     * @throws ImportFileException if there is an error importing the file data.
     */
    public void importFile(String filename) throws ImportFileException {
        _hotel.importFile(filename);  // Delegate the import process to the hotel object
    }

    /**
     * Gets the name of the file currently associated with the hotel's state.
     * 
     * @return the filename associated with the hotel
     */
    public String getFilename() { 
        return _associatedFile;
    }

    /**
     * Sets the filename to associate with the hotel's state.
     * 
     * @param filename the name of the file to associate
     */
    public void setFilename(String filename) { 
        _associatedFile = filename;
    }

    /**
     * Gets the current hotel object being managed.
     * 
     * @return the current hotel object
     */
    public Hotel getHotel() {
        return _hotel;
    }

    /**
     * Checks if the hotel data has been changed.
     * 
     * @return true if the hotel has unsaved changes, false otherwise
     */
    public boolean changed() {
        return _hotel.hasChanged();
    }

    /**
     * Resets the hotel manager by creating a new hotel and clearing the associated file.
     */
    public void reset() {
        _hotel = new Hotel();  // Reset the hotel object
        _associatedFile = null;  // Clear the associated file
    }
}
