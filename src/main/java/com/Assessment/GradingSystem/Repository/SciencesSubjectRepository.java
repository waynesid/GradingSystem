package com.Assessment.GradingSystem.Repository;

import com.Assessment.GradingSystem.Entity.ScienceSubject;
import com.Assessment.GradingSystem.Entity.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author wayne
 * @Date 03/05/2023
 */
public interface SciencesSubjectRepository extends CrudRepository<ScienceSubject, Long> {
    Subject findBySubjectName(String subjectName);



}
