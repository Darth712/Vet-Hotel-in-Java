package hva.app.search;

import hva.Hotel;
import hva.app.ToStringVisitor;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.app.employee.Prompt;
import hva.exceptions.UnknownEmployeeException;
import hva.exceptions.UnknownVetException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowMedicalActsByVeterinarian extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoShowMedicalActsByVeterinarian(Hotel receiver) {
        super(Label.MEDICAL_ACTS_BY_VET, receiver);
        addStringField("id", Prompt.employeeKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.vetActs(stringField("id"))
            .stream()            
            .map(vaccination -> vaccination.accept(TSV))  
            .forEach(_display::popup); 
        } catch(UnknownVetException e) {
            throw new UnknownVeterinarianKeyException(e.getId());
        } catch(UnknownEmployeeException e) {
            throw new UnknownVeterinarianKeyException(e.getId());
        }
    }

}
