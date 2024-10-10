package hva.app.vaccine;

import hva.Hotel;
import hva.app.ToStringVisitor;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAllVaccines extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoShowAllVaccines(Hotel receiver) {
        super(Label.SHOW_ALL_VACCINES, receiver);

    }

    @Override
    protected final void execute() {
        
        _receiver.getAllVaccines()  
            .stream()              
            .map(employee -> employee.accept(TSV))  
            .forEach(_display::popup); 
    }
}
