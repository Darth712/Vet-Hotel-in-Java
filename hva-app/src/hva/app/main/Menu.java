package hva.app.main;

public class Menu extends pt.tecnico.uilib.menus.Menu implements Label{

    public Menu(hva.HotelManager receiver) {
        super(Label.TITLE, //
                new DoNewFile(receiver),
                new DoOpenFile(receiver),
                new DoSaveFile(receiver),
                new DoAdvanceSeason(receiver),
                new DoShowGlobalSatisfaction(receiver),
                new DoOpenAnimalsMenu(receiver),
                new DoOpenEmployeesMenu(receiver),
                new DoOpenHabitatsMenu(receiver),
                new DoOpenVaccinesMenu(receiver),
                new DoOpenLookupsMenu(receiver)
        );
    }
    public void open(){
        System.out.println(
        TITLE + "\n1 - " + 
        NEW_FILE + "\n2 - " + 
        OPEN_FILE + "\n3 - " + 
        SAVE_FILE +"\n4 - " +
        ADVANCE_SEASON + "\n5 - " +
        SHOW_GLOBAL_SATISFACTION +"\n6 - " +
        MENU_ANIMALS + "\n7 - " +
        MENU_EMPLOYEES+"\n8 - " +
        MENU_HABITATS +"\n9 - " +
        MENU_VACCINES +"\n10 - " +
        MENU_LOOKUPS +"\n0 - Sair\nEscolha uma opção:");
    }

}
