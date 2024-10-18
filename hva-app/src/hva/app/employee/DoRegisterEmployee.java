package hva.app.employee;

import hva.Hotel;
import hva.exceptions.EmployeeExistsException;
import hva.app.exceptions.DuplicateEmployeeKeyException;
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
        try {
            if(stringField("type").equals("VET"))
                _receiver.registerVet(stringField("id"), stringField("name"));
            if(stringField("type").equals("TRT"))
                _receiver.registerHandler(stringField("id"), stringField("name"));
            
        } catch (EmployeeExistsException e) {
            throw new DuplicateEmployeeKeyException(e.getId());
        }
        
      
       
    }

}
