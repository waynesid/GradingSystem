package com.Assessment.GradingSystem.Controller;

import com.Assessment.GradingSystem.Entity.Rank;
import com.Assessment.GradingSystem.Entity.Student;
import com.Assessment.GradingSystem.Repository.StudentRepository;
import com.Assessment.GradingSystem.Service.CalculationService;
import com.Assessment.GradingSystem.Service.CompulsorySubjectService;
import com.Assessment.GradingSystem.Service.StudentRequest;
import com.Assessment.GradingSystem.Service.StudentService;
import com.Assessment.GradingSystem.shared.SaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author wayne
 * @Date 03/05/2023
 */
@RestController
@RequestMapping("/students/")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private CompulsorySubjectService compulsorySubjectService;

    @GetMapping("/totalmarks/{studentId}")
    public ResponseEntity<Double> getTotalMarks(@PathVariable("studentId") Long studentId) {

        Double totalMarks = studentService.getStudentTotalMark(studentId);

        return ResponseEntity.status(HttpStatus.OK).body(totalMarks);

    }

    @GetMapping("/totalPoints/{studentId}")
    public ResponseEntity<Double> getTotalPoints(@PathVariable("id") Long studentId) {

        Double totalPoints = studentService.getStudentTotalPoints(studentId);

        return ResponseEntity.status(HttpStatus.OK).body(totalPoints);

    }

    @GetMapping("/studentRank")
    public ResponseEntity<List<Rank>> getStudentsRankList() {
        List<Rank> rankedStudents = studentService.getStudentsRankList();

        return ResponseEntity.status(HttpStatus.OK).body(rankedStudents);
    }

    @PostMapping("save/students")
    public ResponseEntity<SaveResponse> saveStudents(@RequestBody StudentRequest studentRequest)
            throws IOException {

        SaveResponse saveStudent = studentService.saveStudent(studentRequest);

        return ResponseEntity.status(HttpStatus.OK).body(saveStudent);

    }

    @GetMapping("finalGrade/{studentId}")
    public ResponseEntity<Double> getFinalGrade(@PathVariable("id") Long studentId) {
        Optional<Student> student = studentService.getByStudentId(studentId);
        Double finalGrade = Double.valueOf(calculationService.getFinalGrade(student.get().getTotalPoints()));

        return ResponseEntity.status(HttpStatus.OK).body(finalGrade);
    }

}
