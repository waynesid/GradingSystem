package com.Assessment.GradingSystem.Entity;

import jakarta.persistence.*;

/**
 * @author wayne
 * @Date 02/05/2023
 */
@Entity
@Table(name = "subject_table")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long subjectId;

    @Column(name = "subject_name", nullable = false, unique = false, length = 100)
    private String subjectName;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject_category", nullable = false, unique = false, length = 100)
    private SubjectCategory subjectCategory;


    public Subject(Long subjectId, String subjectName, SubjectCategory subjectCategory) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCategory = subjectCategory;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCategory=" + subjectCategory +
                '}';
    }
}
