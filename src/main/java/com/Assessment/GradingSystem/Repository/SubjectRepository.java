package com.Assessment.GradingSystem.Repository;

import com.Assessment.GradingSystem.Entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wayne
 * @Date 02/05/2023
 */
@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

}
