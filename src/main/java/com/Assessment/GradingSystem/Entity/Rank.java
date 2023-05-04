package com.Assessment.GradingSystem.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author wayne
 * @Date 02/05/2023
 */
public class Rank {

    private String firstName;
    private String lastName;
    private double totalMarks;
    private double totalPoints;
    private String grade;

    public Rank(String firstName, String lastName, double totalMarks, double totalPoints, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalMarks = totalMarks;
        this.totalPoints = totalPoints;
        this.grade = grade;
    }

    public Rank() {
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
