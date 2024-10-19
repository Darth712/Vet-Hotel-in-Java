package hva.app.employee;

import hva.Hotel;
import hva.app.exceptions.NoResponsibilityException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.exceptions.UnknownEmployeeException;
import hva.exceptions.ResponsabilityNotFoundException;
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
        } catch (UnknownEmployeeException e) {
            throw new UnknownEmployeeKeyException(e.getId());
        } catch (ResponsabilityNotFoundException e) {
            throw new NoResponsibilityException(stringField("employeeId"), stringField("resId"));

        }    
    }

}
