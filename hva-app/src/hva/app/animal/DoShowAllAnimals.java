package hva.app.animal;

import hva.Hotel;
import hva.app.ToStringVisitor;
import pt.tecnico.uilib.menus.Command;


class DoShowAllAnimals extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoShowAllAnimals(Hotel receiver) {
        super(Label.SHOW_ALL_ANIMALS, receiver);
    }

    @Override
    protected final void execute() {
        _receiver.getAllAnimals()  
            .stream()            
            .map(animal -> animal.accept(TSV))  
            .forEach(_display::popup); 
    }

}
