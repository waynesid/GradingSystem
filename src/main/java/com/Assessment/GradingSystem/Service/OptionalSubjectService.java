package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.OptionalSubject;
import com.Assessment.GradingSystem.Entity.Subject;

import java.util.Set;

/**
 * @author wayne
 * @Date 03/05/2023
 */
public interface OptionalSubjectService {
    void setOptionalSubjectGrade(Set<OptionalSubject> allOptionalSubject);

    void setOptionalGradePoints(Set<OptionalSubject> allOptionalSubject);

    Subject findBySubjectName(String subjectName);
}
