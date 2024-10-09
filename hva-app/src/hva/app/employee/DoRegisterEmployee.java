package hva.app.employee;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
        addStringField("id",Prompt.employeeKey());
        addStringField("name",Prompt.employeeName());
        String type;
        do {
          type = Form.requestString(Prompt.employeeType());
        } while (!type.equals("TRT") && !type.equals("VET"));
        

    }

    @Override
    protected void execute() throws CommandException {
        //FIXME implement command
    }

}
