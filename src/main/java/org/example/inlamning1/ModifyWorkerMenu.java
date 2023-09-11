package org.example.inlamning1;

import org.example.inlamning1.workers.ListBackedWorkerRepo;

import java.util.List;
import java.util.Scanner;

public class ModifyWorkerMenu extends Menu{

    private static final WorkerRepo workers = new ListBackedWorkerRepo();
    private static final Scanner scanner = new Scanner(System.in);
    public ModifyWorkerMenu() {
        super("Modify Worker Menu:");
        menuOptions = List.of(
                new MenuOption(1, "1. Update worker info by id", () -> updateWorker()),
                new MenuOption(2, "2. Create a new worker", () -> createWorker()),
                new MenuOption(3, "3. Remove a worker by id", () -> removeWorker()),
                new MenuOption(4, "4. Go back to Main Menu", () -> MenuSystem.setState(new MainMenu()))
                );
    }

    private void createWorker(){
        System.out.println("Enter worker type: Intern or Employee");
        String type = scanner.nextLine();
        workers.create(type);
    }
    private void removeWorker(){
        System.out.println(workers.findAllWorkers());
       workers.remove();
    }

    private void updateWorker() {
        System.out.println(workers.findAllWorkers());
        workers.update();
    }
}
