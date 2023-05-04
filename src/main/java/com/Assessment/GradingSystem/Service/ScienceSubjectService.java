package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.ScienceSubject;
import com.Assessment.GradingSystem.Entity.Subject;

import java.util.Set;

/**
 * @author wayne
 * @Date 03/05/2023
 */
public interface ScienceSubjectService {
    void setSciencesSubjectGrade(Set<ScienceSubject> allScienceSubject);

    void setScienceGradePoints(Set<ScienceSubject> allScienceSubject);

    Subject findBySubjectName(String subjectName);

}
