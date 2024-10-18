package hva.app.habitat;

import hva.Hotel;
import hva.app.ToStringVisitor;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.UnknownHabitatException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAllTreesInHabitat extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoShowAllTreesInHabitat(Hotel receiver) {
        super(Label.SHOW_TREES_IN_HABITAT, receiver);
        addStringField("habitatID",Prompt.habitatKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.assertUnknownHabitat(stringField("habitatID"));
            _receiver.getHabitats().get(stringField("habitatID")).getAllTrees() 
            .stream()               
            .map(habitat -> habitat.accept(TSV)) 
            .forEach(_display::popup); 
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getId());
        }

    }

}
