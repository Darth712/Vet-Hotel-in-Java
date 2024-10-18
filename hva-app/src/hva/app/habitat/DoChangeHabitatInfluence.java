package hva.app.habitat;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoChangeHabitatInfluence extends Command<Hotel> {

    DoChangeHabitatInfluence(Hotel receiver) {
        super(Label.CHANGE_HABITAT_INFLUENCE, receiver);
        addStringField("habitatID",Prompt.habitatKey());
        addStringField("speciesID",hva.app.animal.Prompt.speciesKey());
        addOptionField("influence",Prompt.habitatInfluence(),"POS","NEG","NEU");

    }

    @Override
    protected void execute() throws CommandException {
    }

}
