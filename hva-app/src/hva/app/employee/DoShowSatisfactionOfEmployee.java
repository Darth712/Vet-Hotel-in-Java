package hva.app.employee;

import hva.Hotel;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.exceptions.UnknownEmployeeException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowSatisfactionOfEmployee extends Command<Hotel> {

    DoShowSatisfactionOfEmployee(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_EMPLOYEE, receiver);
        addStringField("id", Prompt.employeeKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.assertUnknownEmployee(stringField("id"));
            _display.popup(_receiver.showEmployeeSatisfaction(stringField("id")));

        } catch (UnknownEmployeeException e) {
            throw new UnknownEmployeeKeyException(e.getId());
        }

    }

}
