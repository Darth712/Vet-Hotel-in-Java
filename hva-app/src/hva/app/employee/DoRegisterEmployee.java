package hva.app.employee;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
        addStringField("id",Prompt.employeeKey());
        addStringField("name",Prompt.employeeName());
        addOptionField("type", Prompt.employeeType(), "VET","TRT");
      
    
    }

    @Override
    protected void execute() throws CommandException {
      
       
    }

}
