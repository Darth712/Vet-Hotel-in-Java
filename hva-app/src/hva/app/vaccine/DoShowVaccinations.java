package hva.app.vaccine;

import hva.Hotel;
import hva.app.ToStringVisitor;
import pt.tecnico.uilib.menus.Command;


class DoShowVaccinations extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoShowVaccinations(Hotel receiver) {
        super(Label.SHOW_VACCINATIONS, receiver);
    }

    @Override
    protected final void execute() {
        _receiver.getAllVaccinations()
            .stream()
            .map(vaccination -> vaccination.accept(TSV))
            .forEach(_display::popup); 
    }
}
