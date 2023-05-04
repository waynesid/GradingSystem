package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.Rank;
import com.Assessment.GradingSystem.Entity.Student;
import com.Assessment.GradingSystem.Repository.StudentRepository;
import com.Assessment.GradingSystem.shared.SaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wayne
 * @Date 03/05/2023
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CalculationService calculationService;

    @Override
    public Double getStudentTotalMark(Long studentId) {
        Student student1 = studentRepository.findById(studentId).get();
        double totalMarks = student1.getTotalMarks();
        return totalMarks;
    }

    @Override
    public Double getStudentTotalPoints(Long studentId) {
        Student student1 = studentRepository.findById(studentId).get();
        double totalMarks = student1.getTotalPoints();
        return totalMarks;
    }

    @Override
    public List<Rank> getStudentsRankList() {

        List<Rank> rankList = new ArrayList<>();

        for (Student student : studentRepository.findAll()) {
            Rank rank = new Rank();
            rank.setFirstName(student.getFirstName());
            rank.setLastName(student.getLastName());
            rank.setTotalMarks(student.getTotalMarks());
            rank.setTotalPoints(student.getTotalPoints());
            rank.setGrade(student.getAverageGrade());

            rankList.add(rank);
        }

            Comparator<Rank> compareByTotalPoints = Comparator
                    .comparing(Rank::getTotalPoints);
            Comparator<Rank> compareByTotalMarks = Comparator
                    .comparing(Rank::getTotalMarks);

           rankList.sort(compareByTotalPoints.thenComparing(compareByTotalMarks).reversed());


        return rankList;
    }


    @Override
    public Optional<Student> getByStudentId(Long studentId) {
        Optional<Student> student = Optional.of(new Student());
        student = studentRepository.findById(studentId);
        return student;
    }

    @Override
    public SaveResponse saveStudent(StudentRequest studentRequest) {
        Student student = new Student();

        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setTotalMarks(studentRequest.getTotalMarks());

        student.setTotalPoints(studentRequest.getTotalPoints());
        student.setAverageGrade(studentRequest.getAverageGrade());

        studentRepository.save(student);

        return new SaveResponse(Boolean.TRUE, null);
    }


}
