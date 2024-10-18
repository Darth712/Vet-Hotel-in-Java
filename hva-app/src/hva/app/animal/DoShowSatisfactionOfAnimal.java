package hva.app.animal;

import hva.Hotel;
import hva.app.exceptions.UnknownAnimalKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.exceptions.UnknownAnimalException;

class DoShowSatisfactionOfAnimal extends Command<Hotel> {

    DoShowSatisfactionOfAnimal(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
        addStringField("id", Prompt.animalKey());
    }

    @Override
    protected final void execute() throws CommandException {
        try {
            _receiver.assertUnknownAnimal(stringField("id"));
            _display.popup((_receiver.showAnimalSatisfaction(stringField("id"))));

        } catch (UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(e.getId());
        }
    
    }

}
