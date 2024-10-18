package hva.app.main;

import hva.HotelManager;
import hva.app.ToStringVisitor;
import pt.tecnico.uilib.menus.Command;

    

class DoAdvanceSeason extends Command<HotelManager> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoAdvanceSeason(HotelManager receiver) {
        super(Label.ADVANCE_SEASON, receiver);

    }

    @Override
    protected final void execute() {
        _receiver.getHotel().advanceSeason();
        _display.popup(_receiver.getHotel().getSeason().getCode());
    }
}
