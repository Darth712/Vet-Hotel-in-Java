package hva.app.search;

import hva.Hotel;
import hva.app.ToStringVisitor;
import hva.app.habitat.Prompt;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.UnknownHabitatException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAnimalsInHabitat extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoShowAnimalsInHabitat(Hotel receiver) {
        super(Label.ANIMALS_IN_HABITAT, receiver);
        addStringField("id", Prompt.habitatKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.showAnimalsInHabitat(stringField("id"))
            .stream()            
            .map(animal -> animal.accept(TSV))  
            .forEach(_display::popup); 
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getId());
        }
    }

}
