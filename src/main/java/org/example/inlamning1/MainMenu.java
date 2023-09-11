package org.example.inlamning1;


import java.util.List;

public class MainMenu extends Menu implements MenuState {


    public MainMenu() {
        super("Main Menu");
        menuOptions = List.of(
                new MenuOption(1, "1. Go to worker info Menu", () -> MenuSystem.setState(new WorkerInfoMenu())),
                new MenuOption(2, "2. Create, modify or remove worker Menu", () ->MenuSystem.setState(new ModifyWorkerMenu())),
                new MenuOption(3, "3. Quit", () -> System.exit(0))
        );
    }
}
