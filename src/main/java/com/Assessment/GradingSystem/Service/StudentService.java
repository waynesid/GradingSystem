package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.Rank;
import com.Assessment.GradingSystem.Entity.Student;
import com.Assessment.GradingSystem.shared.SaveResponse;

import java.util.List;
import java.util.Optional;

/**
 * @author wayne
 * @Date 03/05/2023
 */
public interface StudentService {

    Optional<Student> getByStudentId(Long studentId);

    SaveResponse saveStudent(StudentRequest studentRequest);


    Double getStudentTotalMark(Long studentId);

    Double getStudentTotalPoints(Long studentId);

    List<Rank> getStudentsRankList();
}
