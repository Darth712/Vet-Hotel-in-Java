package hva.app.habitat;

import hva.Hotel;
import hva.exceptions.TreeExistsException;
import hva.exceptions.UnknownHabitatException;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.ToStringVisitor;
import hva.app.exceptions.DuplicateTreeKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoAddTreeToHabitat extends Command<Hotel> {

    private final ToStringVisitor TSV = new ToStringVisitor();

    DoAddTreeToHabitat(Hotel receiver) {
        super(Label.ADD_TREE_TO_HABITAT, receiver);
        addStringField("habitatId",Prompt.habitatKey());
        addStringField("treeId", Prompt.treeKey());
        addStringField("treeName",Prompt.treeName());
        addIntegerField("treeAge",Prompt.treeAge());
        addIntegerField("treeDiff",Prompt.treeDifficulty());
        addOptionField("type", Prompt.treeType(), "CADUCA","PERENE");
    }

    @Override
    protected void execute() throws CommandException {
        try{
            _receiver.assertUnknownHabitat(stringField("habitatId"));
            _receiver.registerTree(stringField("treeId"), stringField("treeName"), 
            integerField("treeAge"), integerField("treeDiff"), stringField("type"));
            _receiver.addTreeToHabitat(stringField("habitatId"), stringField("treeId"));
            _display.popup(_receiver.getTree(stringField("treeId")).accept(TSV));
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getId());

        } catch (TreeExistsException e) {
            throw new DuplicateTreeKeyException(e.getId());
        }


    }

}
