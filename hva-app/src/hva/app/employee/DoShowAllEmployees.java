package hva.app.employee;

import hva.Hotel;
import hva.app.ToStringVisitor;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAllEmployees extends Command<Hotel> {

    private final ToStringVisitor tsv = new ToStringVisitor();

    DoShowAllEmployees(Hotel receiver) {
        super(Label.SHOW_ALL_EMPLOYEES, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        _receiver.getAllEmployees()  
            .stream()              
            .map(employee -> employee.accept(tsv))  
            .forEach(_display::popup); 
    }

}
