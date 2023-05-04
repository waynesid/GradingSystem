package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.OptionalSubject;
import com.Assessment.GradingSystem.Entity.Subject;
import com.Assessment.GradingSystem.Repository.OptionalSubjectRepository;
import com.Assessment.GradingSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author wayne
 * @Date 03/05/2023
 */
@Service
public class OptionalSubjectServiceImpl implements OptionalSubjectService {

    @Value("${optional.subjects.max.number}")
    private Integer optionalSubjectsMaxNumber;

    @Autowired
    private OptionalSubjectRepository optionalSubjectRepository;



    @Autowired
    private CalculationService calculationService;


    private void addToSetIfLessThan(Integer optionalSubjectsNumber, OptionalSubject optionalSubject, Set<OptionalSubject> allOptionalSubject) {

        if (optionalSubjectsNumber < optionalSubjectsMaxNumber) {
            allOptionalSubject.add(optionalSubject);

        }
    }


    @Override
    public void setOptionalSubjectGrade(Set<OptionalSubject> allOptionalSubject) {

        for (OptionalSubject optionalSubject : allOptionalSubject) {

            Integer subjectScore = (int) optionalSubject.getStudentScore();
            String subjectScoreGrade = calculationService.subjectScoreGrade(subjectScore);
            optionalSubject.setScoreGrade(subjectScoreGrade);
        };

    }

    @Override
    public void setOptionalGradePoints(Set<OptionalSubject> allOptionalSubject) {
        for (OptionalSubject optionalSubject : allOptionalSubject) {

            String subjectGrade = optionalSubject.getScoreGrade();
            Double gradePoints = calculationService.subjectScorePoints(subjectGrade);
            optionalSubject.setGradePoints(gradePoints);
        }
    }

    @Override
    public Subject findBySubjectName(String subjectName) {
        optionalSubjectRepository.findBySubjectName(subjectName);

        return optionalSubjectRepository.findBySubjectName(subjectName);
    }

}
