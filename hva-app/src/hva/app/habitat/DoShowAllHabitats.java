package hva.app.habitat;

import hva.Hotel;
import hva.app.ToStringVisitor;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAllHabitats extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoShowAllHabitats(Hotel receiver) {
        super(Label.SHOW_ALL_HABITATS, receiver);
    }

    @Override
    protected void execute() {
        _receiver.getAllHabitats() 
            .stream()               
            .map(habitat -> habitat.accept(TSV)) 
            .forEach(_display::popup); 
    }
}
