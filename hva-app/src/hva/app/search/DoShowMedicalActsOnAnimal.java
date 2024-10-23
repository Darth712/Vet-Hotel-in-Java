package hva.app.search;

import hva.Hotel;
import hva.app.ToStringVisitor;
import hva.app.animal.Prompt;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.exceptions.UnknownAnimalException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowMedicalActsOnAnimal extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoShowMedicalActsOnAnimal(Hotel receiver) {
        super(Label.MEDICAL_ACTS_ON_ANIMAL, receiver);
        addStringField("id",Prompt.animalKey());

    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.actsOnAnimal(stringField("id"))
            .stream()
            .map(vaccination -> vaccination.accept(TSV))
            .forEach(_display::popup);
        } catch(UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(e.getId());
        }
        
    }

}
