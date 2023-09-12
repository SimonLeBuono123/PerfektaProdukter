package org.example.inlamning1.workers;

import org.example.inlamning1.MenuSystem;
import org.example.inlamning1.ModifyWorkerMenu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Worker {
    private String name;
    private final int id;
    private static int counter = 1;
    private String gender;
    private static Scanner scanner = new Scanner(System.in);
    public Worker(String name, String gender) {
        this.name = name;
        this.id = counter++;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static Worker getClassType(String classType){
        return switch (classType.toUpperCase().charAt(0)){
            case 'I' -> {
                System.out.println("Enter the Name: ");
                String name = scanner.nextLine();
                System.out.println("Enter the Gender(M or F): ");
                String gender = scanner.nextLine();
                System.out.println("Enter end date (yyyy, mm, dd)");
                LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                yield new Intern(name, gender, endDate);
            }
            case 'E' -> {
                System.out.println("Enter the Name: ");
                String name = scanner.nextLine();
                System.out.println("Enter the Gender(M or F): ");
                String gender = scanner.nextLine();
                System.out.println("Enter starting date (yyyy, mm, dd)");
                LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                System.out.println("Enter the monthly income");
                int income = scanner.nextInt();
                yield  new Employee(name, gender, startDate, income);

            }
            default -> {
                    throw new IllegalStateException("invalid statement" + classType
                            + "\nexpected Employee or intern");
            }
        };
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gender='" + gender + '\'' +
                '}';
    }
}
