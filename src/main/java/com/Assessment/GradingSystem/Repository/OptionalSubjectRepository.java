package com.Assessment.GradingSystem.Repository;

import com.Assessment.GradingSystem.Entity.OptionalSubject;
import com.Assessment.GradingSystem.Entity.Subject;
import org.springframework.data.repository.CrudRepository;

/**
 * @author wayne
 * @Date 03/05/2023
 */
public interface OptionalSubjectRepository extends CrudRepository<OptionalSubject, Long> {
    Subject findBySubjectName(String subjectName);
}
