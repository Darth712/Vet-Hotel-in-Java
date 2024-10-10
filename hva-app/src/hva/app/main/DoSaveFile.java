package hva.app.main;

import hva.HotelManager;
import hva.app.exceptions.FileOpenFailedException;
import hva.exceptions.MissingFileAssociationException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import java.io.IOException;

class DoSaveFile extends Command<HotelManager> {
    DoSaveFile(HotelManager receiver) {
        super(Label.SAVE_FILE, receiver, r -> r.getHotel() != null);
    }

    @Override
    protected final void execute() throws CommandException{
    	try { 
            _receiver.save();
        } 
        catch (MissingFileAssociationException e) {
            String filename = Form.requestString(Prompt.newSaveAs());
            try {
                _receiver.saveAs(filename);
            } catch (IOException e2) {
                throw new FileOpenFailedException(e2);
            } catch (MissingFileAssociationException e2) {
                
            }
        } catch (IOException e) {
            
        }
    }
}

