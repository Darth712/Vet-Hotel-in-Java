package hva.app.habitat;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.exceptions.UnknownHabitatException;
import hva.app.exceptions.UnknownHabitatKeyException;

class DoChangeHabitatArea extends Command<Hotel> {

    DoChangeHabitatArea(Hotel receiver) {
        super(Label.CHANGE_HABITAT_AREA, receiver);
        addStringField("habitatId", Prompt.habitatKey());
        addIntegerField("area", Prompt.habitatArea());

    }

    @Override
    protected void execute() throws CommandException {
        try{
            _receiver.changeHabitatArea(stringField("habitatId"),integerField("area"));
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getId());
        }

    }

}
