package hva.app.employee;

import hva.Hotel;
import hva.app.exceptions.NoResponsibilityException;
import hva.exceptions.UnknownResponsabilityException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoRemoveResponsibility extends Command<Hotel> {

    DoRemoveResponsibility(Hotel receiver) {
        super(Label.REMOVE_RESPONSABILITY, receiver);
        addStringField("employeeId", Prompt.employeeKey());
        addStringField("resId", Prompt.responsibilityKey());
        
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.removeResponsability(stringField("employeeId"), stringField("resId"));
        } catch (UnknownResponsabilityException e) {
            throw new NoResponsibilityException(stringField("employeeId"), stringField("resId"));
        }


    }

}
