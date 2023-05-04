package com.Assessment.GradingSystem.Service;

/**
 * @author wayne
 * @Date 02/05/2023
 */
public interface CalculationService {

    Double getTotalMarks(StudentRequest studentRequest, Long studentId);

    Double getTotalPoints(StudentRequest studentRequest, Long studentId);

    String getFinalGrade(Double totalPoints);

    String subjectScoreGrade(Integer subjectScore);

    Double subjectScorePoints(String grade);

    Double subjectMean(String subjectName);


}
