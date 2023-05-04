package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.CompulsorySubject;
import com.Assessment.GradingSystem.Entity.OptionalSubject;
import com.Assessment.GradingSystem.Entity.ScienceSubject;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wayne
 * @Date 03/05/2023
 */
public class StudentRequest {

    private Long studentId;

    private String firstName;
    private String lastName;

    private Set<CompulsorySubject> compulsorySubjects = new HashSet<>();

    private Set<ScienceSubject> sciencesSubjects = new HashSet<>();

    private Set<OptionalSubject> optionalSubjects = new HashSet<>();

    private String averageGrade;

    private double totalMarks;

    private double totalPoints;

    public StudentRequest(Long studentId, String firstName, String lastName, Set<CompulsorySubject> compulsorySubjects, Set<ScienceSubject> sciencesSubjects, Set<OptionalSubject> optionalSubjects, String averageGrade, int totalMarks, int totalPoints) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.compulsorySubjects = compulsorySubjects;
        this.sciencesSubjects = sciencesSubjects;
        this.optionalSubjects = optionalSubjects;
        this.averageGrade = averageGrade;
        this.totalMarks = totalMarks;
        this.totalPoints = totalPoints;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Set<CompulsorySubject> getCompulsorySubjects() {
        return compulsorySubjects;
    }

    public void setCompulsorySubjects(Set<CompulsorySubject> compulsorySubjects) {
        this.compulsorySubjects = compulsorySubjects;
    }

    public Set<ScienceSubject> getSciencesSubjects() {
        return sciencesSubjects;
    }

    public void setSciencesSubjects(Set<ScienceSubject> sciencesSubjects) {
        this.sciencesSubjects = sciencesSubjects;
    }

    public Set<OptionalSubject> getOptionalSubjects() {
        return optionalSubjects;
    }

    public void setOptionalSubjects(Set<OptionalSubject> optionalSubjects) {
        this.optionalSubjects = optionalSubjects;
    }

    public String getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(String averageGrade) {
        this.averageGrade = averageGrade;
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
}
