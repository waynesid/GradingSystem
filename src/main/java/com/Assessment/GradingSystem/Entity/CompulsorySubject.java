package com.Assessment.GradingSystem.Entity;

import jakarta.persistence.*;

/**
 * @author wayne
 * @Date 02/05/2023
 */
@Entity(name = "compulsory_subject_table")
public class CompulsorySubject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long subjectId;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Column(name = "student_score")
    private double studentScore;

    @ManyToOne
    @JoinTable(name = "compulsory_subject_table_student", joinColumns = {
            @JoinColumn(name = "subjectId", foreignKey = @ForeignKey(name = "compulsory_subject_table_fk_compulsory_subject"))}, inverseJoinColumns = {
            @JoinColumn(name = "studentId", foreignKey = @ForeignKey(name = "compulsory_subject_table_fk_student"))})
    private Student student;

    @Column(name = "subject_category")
    private SubjectCategory subjectCategory;

    @Column(name = "grade_points")
    private double gradePoints;

    @Column(name = "score_grade")
    private String scoreGrade;


    public CompulsorySubject() {
    }

    public CompulsorySubject(Long subjectId, String subjectName, double studentScore, Student student, SubjectCategory subjectCategory, double gradePoints, String scoreGrade) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.studentScore = studentScore;
        this.student = student;
        this.subjectCategory = subjectCategory;
        this.gradePoints = gradePoints;
        this.scoreGrade = scoreGrade;
    }

    public double getGradePoints() {
        return gradePoints;
    }

    public void setGradePoints(double gradePoints) {
        this.gradePoints = gradePoints;
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
        this.subjectCategory = SubjectCategory.COMPULSORY;
    }

    public double getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(double studentScore) {
        this.studentScore = studentScore;
    }

    public String getScoreGrade() {
        return scoreGrade;
    }

    public void setScoreGrade(String scoreGrade) {
        this.scoreGrade = scoreGrade;
    }
}
