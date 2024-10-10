package hva.app.animal;

import hva.Hotel;
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
        
    }

}
