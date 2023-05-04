package com.Assessment.GradingSystem.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wayne
 * @Date 02/05/2023
 */
@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "first_name",unique = false, length = 100)
    private String firstName;

    @Column(name = "last_name", unique = false, length = 100)
    private String lastName;


    @OneToMany(mappedBy = "student")
    private Set<CompulsorySubject> compulsorySubjects = new HashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<ScienceSubject> sciencesSubjects = new HashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<OptionalSubject> optionalSubjects = new HashSet<>();

    @Column(name = "average_grade", nullable = true)
    private String averageGrade;

    @Column(name = "total_marks", nullable = true)
    private double totalMarks;

    @Column(name = "total_points", nullable = true)
    private double totalPoints;

    public Student(Long studentId, String firstName, String lastName, Set<CompulsorySubject> compulsorySubjects, Set<ScienceSubject> sciencesSubjects, Set<OptionalSubject> optionalSubjects, String averageGrade, double totalMarks, double totalPoints) {
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

    public Student() {
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

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", compulsorySubjects=" + compulsorySubjects +
                ", sciencesSubjects=" + sciencesSubjects +
                ", optionalSubjects=" + optionalSubjects +
                ", averageGrade=" + averageGrade +
                ", totalMarks=" + totalMarks +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
