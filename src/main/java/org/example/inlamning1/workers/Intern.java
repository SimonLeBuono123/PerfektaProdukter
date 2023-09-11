package org.example.inlamning1.workers;

import java.time.LocalDate;

public class Intern extends Worker{

    private LocalDate endDate;
    private String recommendation;

    public Intern(String name, String gender) {
        super(name, gender);
    }

    public Intern(String name, String gender, LocalDate endDate) {
        super(name, gender);
        this.endDate = endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public String toString() {
        return "\nIntern{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", gender='" + this.getGender() + '\'' +
                "EndDate=" + endDate +
                ", Statement=" + recommendation + "\n" + "}";

    }

}
