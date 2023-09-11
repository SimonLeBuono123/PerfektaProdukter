package org.example.inlamning1.workers;

import java.time.LocalDate;

public class Employee extends Worker{

    private LocalDate StartDate;

    private int monthlyIncome;

    public Employee(String name,  String gender) {
        super(name, gender);
    }

    public Employee(String name, String gender, LocalDate startDate, int monthlyIncome) {
        super(name, gender);
        StartDate = startDate;
        this.monthlyIncome = monthlyIncome;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", gender='" + this.getGender() + '\'' +
                "StartDate=" + ", " + StartDate +
                ", monthlyIncome=" + monthlyIncome + "\n" + "}";

    }
}
