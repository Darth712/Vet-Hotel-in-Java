package hva.app.vaccine;

import hva.Hotel;
import hva.app.exceptions.DuplicateVaccineKeyException;
import hva.exceptions.UnknownSpeciesException;
import hva.exceptions.VaccineExistsException;
import hva.app.exceptions.UnknownSpeciesKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterVaccine extends Command<Hotel> {

    DoRegisterVaccine(Hotel receiver) {
        super(Label.REGISTER_VACCINE, receiver);
        addStringField("id",Prompt.vaccineKey());
        addStringField("name",Prompt.vaccineName());
        addStringField("species",Prompt.listOfSpeciesKeys());

    }

    @Override
    protected final void execute() throws CommandException {
        try {
            _receiver.registerVaccine(stringField("id"),
            stringField("name"),stringField("species"));
        } catch (VaccineExistsException e) {
            throw new DuplicateVaccineKeyException(e.getId());
        } catch(UnknownSpeciesException e) {
            throw new UnknownSpeciesKeyException(e.getId());
        }
    }

}
