package hva.app.animal;

import hva.Hotel;
import hva.app.exceptions.DuplicateAnimalKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.*;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;




class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
        addStringField("id", Prompt.animalKey());
        addStringField("name",Prompt.animalName());
        addStringField("species",Prompt.speciesKey());
        addStringField("habitat",hva.app.habitat.Prompt.habitatKey());

    }

    @Override
    protected final void execute() throws CommandException {
        
        try{
            _receiver.registerAnimal(stringField("id"), 
            stringField("name"), stringField("species"), stringField("habitat"));
        } catch (AnimalExistsException e) {
            throw new DuplicateAnimalKeyException(e.getId());
        } catch (UnknownSpeciesException e) {
            Form request = new Form();
            request.addStringField("speciesName", Prompt.speciesName());
            request.parse();
            _receiver.registerSpecies(e.getId(), request.stringField("speciesName"));
            
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getId());
        } catch (UnrecognizedEntryException e) {
            e.printStackTrace();
        }

        
    }

}
