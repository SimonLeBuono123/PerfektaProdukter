package org.example.inlamning1;


import org.example.inlamning1.workers.ListBackedWorkerRepo;

import java.util.List;

public class EmployeeInfoMenu extends Menu{
    private static final WorkerRepo workers = new ListBackedWorkerRepo();
   public EmployeeInfoMenu(){
       super("Employee Menu");
       menuOptions = List.of(
               new MenuOption(1, "1. Employees ordered by start date", () ->
                       getAllEmployeeInfo()),
               new MenuOption(2, "2. Average Salary between Male and female employees",
                       () -> workers.findAverageIncomeByGender()),
               new MenuOption(3, "3. go to Main Menu", () -> MenuSystem.setState(new MainMenu()))
       );
    }

    private void getAllEmployeeInfo(){
        System.out.println(workers.findAllEmployees());
    }

}
