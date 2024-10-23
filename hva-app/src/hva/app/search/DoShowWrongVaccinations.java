package hva.app.search;

import hva.Hotel;
import hva.app.ToStringVisitor;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowWrongVaccinations extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoShowWrongVaccinations(Hotel receiver) {
        super(Label.WRONG_VACCINATIONS, receiver);

    }

    @Override
    protected void execute() throws CommandException {
        _receiver.getWrongVaccinations()
        .stream()
        .map(vaccination -> vaccination.accept(TSV))
        .forEach(_display::popup);
    }

}
