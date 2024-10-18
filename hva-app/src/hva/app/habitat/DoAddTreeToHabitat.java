package hva.app.habitat;

import hva.Hotel;
import hva.exceptions.TreeExistsException;
import hva.app.exceptions.DuplicateTreeKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoAddTreeToHabitat extends Command<Hotel> {

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
            _receiver.registerTree(stringField("treeId"), stringField("treeName"), 
            integerField("treeAge"), integerField("treeDiff"), stringField("type"));
            _receiver.addTreeToHabitat(stringField("habitatId"), stringField("treeId"));
        } catch (TreeExistsException e) {
            throw new DuplicateTreeKeyException(e.getId());
        }


    }

}
