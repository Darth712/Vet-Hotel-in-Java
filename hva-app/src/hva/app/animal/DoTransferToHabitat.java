package hva.app.animal;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.exceptions.UnknownHabitatException;
import hva.exceptions.UnrecognizedEntryException;
import hva.exceptions.UnknownAnimalException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoTransferToHabitat extends Command<Hotel> {

    DoTransferToHabitat(Hotel hotel) {
        super(Label.TRANSFER_ANIMAL_TO_HABITAT, hotel);
        addStringField("animalId",Prompt.animalKey());
        addStringField("habitatId",hva.app.habitat.Prompt.habitatKey());
    }

    @Override
    protected final void execute() throws CommandException {
        try{
            _receiver.animalToHabitat(stringField("animalId"),stringField("habitatId"));
        } catch (UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(e.getId());
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getId());
        }   catch (UnrecognizedEntryException e) {
            e.printStackTrace();
        }

   
    }

}
