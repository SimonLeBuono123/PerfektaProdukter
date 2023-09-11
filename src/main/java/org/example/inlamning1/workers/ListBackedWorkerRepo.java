package org.example.inlamning1.workers;

import org.example.inlamning1.MenuSystem;
import org.example.inlamning1.ModifyWorkerMenu;
import org.example.inlamning1.WorkerRepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ListBackedWorkerRepo implements WorkerRepo {

    private final static Scanner scanner = new Scanner(System.in);

    private final static List<Worker> workers = new ArrayList<>(List.of(
            new Intern("Tom", "M", LocalDate.parse("2010-07-10", DateTimeFormatter.ISO_LOCAL_DATE)),
            new Employee("Lord", "M", LocalDate.parse("2010-09-10", DateTimeFormatter.ISO_LOCAL_DATE), 20000),
            new Employee("Lord", "F", LocalDate.parse("2010-11-10", DateTimeFormatter.ISO_LOCAL_DATE), 23000),
            new Employee("Lord", "M", LocalDate.parse("2008-07-10", DateTimeFormatter.ISO_LOCAL_DATE),38000),
            new Employee("Sven", "F", LocalDate.parse("2015-07-10", DateTimeFormatter.ISO_LOCAL_DATE), 19000)
    ));

    @Override
    public void create(String type) {
        Worker worker = Worker.getClassType(type);
        workers.add(worker);
    }

    @Override
    public void update() {
        System.out.println("Choose the id of the worker to update, or press 0 to go back");
        int workerId = scanner.nextInt();
        if(workerId == 0) MenuSystem.setState(new ModifyWorkerMenu());
        int foundId = findWorkerById(workerId);
        if(foundId != -1){
            updateWorkerInfo(foundId);
        }else {
            System.out.println("No such worker exists");
        }

    }

    @Override
    public void remove() {
        System.out.println("Choose the id of the worker to delete, or press 0 to go back");
        int workerId = scanner.nextInt();
        if(workerId == 0) MenuSystem.setState(new ModifyWorkerMenu());

        if(findWorkerById(workerId) != -1){
            workers.remove(findWorkerById(workerId));
            System.out.println("Worker has successfully been removed");
        }else{
            System.out.println("No such worker exists");
        }
    }

    @Override
    public void findAverageIncomeByGender() {
        double female = 0;
        double male = 0;
        double femaleAverage = 0;
        double maleAverage = 0;
        int f = 0;
        int m = 0;
        for(Worker worker : workers){
            if(worker instanceof Employee){
                if(worker.getGender().contains("F")){
                    f++;
                    female += ((Employee) worker).getMonthlyIncome();
                     femaleAverage = female / f;
                }
                if(worker.getGender().contains("M")){
                   m++;
                   male += ((Employee) worker).getMonthlyIncome();
                    maleAverage = male / m;
                }
            }
        }
        System.out.println("Average Male income: " + maleAverage + "\n " +
                "Average Female income: " + femaleAverage);
    }

    public List<Worker> findAllWorkers() {
        List<Worker> returnList = new ArrayList<>();
        for(Worker worker : workers){
             returnList.add(worker);
        }
        return returnList;
    }
    public List<Worker> findAllInterns(){
        List<Worker> returnList = new ArrayList<>();
        for(Worker worker : workers){
            if(worker instanceof Intern)
            returnList.add(worker);
        }
        return returnList;
    }
    public List<Worker> findAllEmployees() {
        List<Worker> returnList = new ArrayList<>();
            for(Worker worker : workers){
                if(worker instanceof Employee){
                    returnList.add(worker);
                    Collections.sort(returnList, new Comparator<Worker>() {
                        @Override
                        public int compare(Worker o1, Worker o2) {
                            if(o1 instanceof Employee && o2 instanceof Employee){
                                return ((Employee) o1).getStartDate().compareTo(((Employee) o2).getStartDate());
                            }
                            return 0;
                        }
                    });
                }
            }
            return returnList;
        }

    @Override
    public int workerAmount() {
        return workers.size();
    }

    @Override
    public int findWorkerById(int workerId) {
        for(int i = 0; i < workers.size(); i++){
            if(workers.get(i).getId() == workerId){
                return i;
            }
        }
        return -1;
    }


    private void updateWorkerInfo(int workerId){
        boolean flag = true;
        while(flag){
            String updateChoices = scanner.nextLine();
            //First one is for changing value of the Employees
            if(workers.get(workerId) instanceof Employee) {
                System.out.println("Type in one of these for which you want to update: ");
                System.out.println("Employee: \"name\", \"gender \", \"income\" or type close to exit");
                System.out.println(workers.get(workerId));
                switch (updateChoices.toLowerCase()) {
                    case "name" -> {
                        System.out.println("Set name: ");
                        String name = scanner.nextLine();
                        workers.get(workerId).setName(name);
                    }
                    case "gender" -> {
                        System.out.println("Change gender(to F or M)");
                        String gender = scanner.nextLine();
                        workers.get(workerId).setGender(gender);
                    }
                    case "income" -> {
                        System.out.println("Update income: ");
                        int income = scanner.nextInt();
                        ((Employee) workers.get(workerId)).setMonthlyIncome(income);
                    }
                    case "close"-> flag = false;

                }
            }
            //Second one is for changing the values of interns
            else if(workers.get(workerId) instanceof Intern){
                System.out.println("Type in one of these for which you want to update: ");
                System.out.println("Intern: \"name\", \"gender \", \"enddate\", \"statement\" ");
                System.out.println(workers.get(workerId));
                switch (updateChoices.toLowerCase()){
                    case "name" -> {
                        System.out.println("Set name: ");
                        String name = scanner.nextLine();
                        workers.get(workerId).setName(name);
                    }
                    case "gender" -> {
                        System.out.println("Change gender(to F or M)");
                        String gender = scanner.nextLine();
                        workers.get(workerId).setGender(gender);
                    }
                    case "endDate" -> {
                        System.out.println("Update the end date of intern");
                        LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                        ((Intern) workers.get(workerId)).setEndDate(endDate);
                    }
                    case "statement"-> {
                        System.out.println("Enter a statement for the intern");
                        String recommendation = scanner.nextLine();
                        ((Intern) workers.get(workerId)).setRecommendation(recommendation);
                    }
                    case "close"-> flag = false;

                }
            }
        }
    }
}
