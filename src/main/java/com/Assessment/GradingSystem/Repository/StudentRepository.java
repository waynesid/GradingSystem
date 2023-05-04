package com.Assessment.GradingSystem.Repository;

import com.Assessment.GradingSystem.Entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wayne
 * @Date 02/05/2023
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {


}
