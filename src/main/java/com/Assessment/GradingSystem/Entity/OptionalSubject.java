package com.Assessment.GradingSystem.Entity;

import jakarta.persistence.*;

/**
 * @author wayne
 * @Date 02/05/2023
 */
@Entity(name = "optional_subject_table")
public class OptionalSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long subjectId;
    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "subject_category")
    private SubjectCategory subjectCategory;

    @Column(name = "student_score")
    private double studentScore;

    @Column(name = "grade_points")
    private double gradePoints;

    @Column(name = "score_grade")
    private String scoreGrade;


    @ManyToOne
    @JoinTable(name = "optional_subject_table_student", joinColumns = {
            @JoinColumn(name = "subjectId", foreignKey = @ForeignKey(name = "optional_subject_table_fk_optional_subject"))}, inverseJoinColumns = {
            @JoinColumn(name = "studentId", foreignKey = @ForeignKey(name = "optional_subject_table_fk_student"))})
    private Student student;

    public OptionalSubject() {
    }

    public OptionalSubject(Long subjectId, String subjectName, SubjectCategory subjectCategory, double studentScore, double gradePoints, String scoreGrade, Student student) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCategory = subjectCategory;
        this.studentScore = studentScore;
        this.gradePoints = gradePoints;
        this.scoreGrade = scoreGrade;
        this.student = student;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public SubjectCategory getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategory subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public double getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(double studentScore) {
        this.studentScore = studentScore;
    }

    public double getGradePoints() {
        return gradePoints;
    }

    public void setGradePoints(double gradePoints) {
        this.gradePoints = gradePoints;
    }

    public String getScoreGrade() {
        return scoreGrade;
    }

    public void setScoreGrade(String scoreGrade) {
        this.scoreGrade = scoreGrade;
    }
}
