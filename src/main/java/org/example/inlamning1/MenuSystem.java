package org.example.inlamning1;

public class MenuSystem implements MenuState{
    private static MenuState activeMenu;
    private static MenuSystem menuSystem = new MenuSystem();

    public MenuSystem(){
         activeMenu = new MainMenu();
    }

    public static MenuSystem getInstance() {
        return menuSystem;
    }

    public static void setState(MenuState selectedMenu){
        activeMenu = selectedMenu;
    }
    @Override
    public void execute() {
        activeMenu.execute();
    }
}
