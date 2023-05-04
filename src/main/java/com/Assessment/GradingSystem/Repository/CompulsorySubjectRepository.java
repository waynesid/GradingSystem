package com.Assessment.GradingSystem.Repository;

import com.Assessment.GradingSystem.Entity.CompulsorySubject;
import com.Assessment.GradingSystem.Entity.Subject;
import org.springframework.data.repository.CrudRepository;

/**
 * @author wayne
 * @Date 03/05/2023
 */
public interface CompulsorySubjectRepository extends CrudRepository<CompulsorySubject, Long> {
    Subject findBySubjectName(String subjectName);

}
