package org.example.inlamning1;

import org.example.inlamning1.workers.ListBackedWorkerRepo;

import java.util.List;

public class WorkerInfoMenu extends Menu implements MenuState {
    private static final WorkerRepo workers = new ListBackedWorkerRepo();

    public WorkerInfoMenu() {
        super("Information About workers");
        menuOptions = List.of(
                new MenuOption(1, "1. All workers", () -> getAllWorkers()),
                new MenuOption(2, "2. Interns info", () -> getAllInterns()),
                new MenuOption(3, "3. Employees Menu", () -> MenuSystem.setState(new EmployeeInfoMenu())),
                new MenuOption(4, "4. Go back to Main Menu", () -> MenuSystem.setState(new MainMenu()))
        );
    }

    public void getAllWorkers() {
        System.out.println(workers.findAllWorkers());
        System.out.printf("There is a total of %s people working here right now.%n"
                , workers.workerAmount());
    }

    public void getAllInterns() {
        System.out.println(workers.findAllInterns());
    }

}
