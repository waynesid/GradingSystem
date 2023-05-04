package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.CompulsorySubject;
import com.Assessment.GradingSystem.Entity.Subject;

import java.util.Set;

/**
 * @author wayne
 * @Date 03/05/2023
 */
public interface CompulsorySubjectService {
    void setCompulsorySubjectGrade(Set<CompulsorySubject> allCompulsorySubject);

    void setCompulsoryGradePoints(Set<CompulsorySubject> allCompulsorySubject);
    Subject findBySubjectName(String subjectName);
}
