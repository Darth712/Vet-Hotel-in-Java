package hva.app.vaccine;

import hva.Hotel;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.UnknownVaccineKeyException;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.app.exceptions.VeterinarianNotAuthorizedException;
import hva.exceptions.UnknownAnimalException;
import hva.exceptions.UnknownEmployeeException;
import hva.exceptions.UnknownVaccineException;
import hva.exceptions.UnknownVetException;
import hva.exceptions.VetNotAuthException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoVaccinateAnimal extends Command<Hotel> {

    DoVaccinateAnimal(Hotel receiver) {
        super(Label.VACCINATE_ANIMAL, receiver);
        addStringField("vaccineId", Prompt.vaccineKey());
        addStringField("vetId", Prompt.veterinarianKey());
        addStringField("animalId", hva.app.animal.Prompt.animalKey());

    }

    @Override
    protected final void execute() throws CommandException {
        try {
            if(_receiver.vaccinateAnimal(stringField("vaccineId"), 
            stringField("vetId"), stringField("animalId"))) {
                _display.popup(Message.wrongVaccine(stringField("vaccineId"), stringField("animalId")));
            }
        } catch ( UnknownVaccineException e) {
            throw new UnknownVaccineKeyException(e.getId());
        } catch (UnknownEmployeeException e) {
            throw new UnknownVeterinarianKeyException(e.getId());
        } catch (UnknownVetException e) {
            throw new UnknownVeterinarianKeyException(e.getId());
        } catch( UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(e.getId());
        } catch (VetNotAuthException e) {
            throw new VeterinarianNotAuthorizedException(e.getVetId(), e.getSpeciesId());
        }

    }

}
