package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.CompulsorySubject;
import com.Assessment.GradingSystem.Entity.Subject;
import com.Assessment.GradingSystem.Repository.CompulsorySubjectRepository;
import com.Assessment.GradingSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author wayne
 * @Date 02/05/2023
 */
@Service
public class CompulsorySubjectServiceImpl implements CompulsorySubjectService {

    @Value("${compulsory.subjects.max.number}")
    private Integer compulsorySubjectsMaxNumber;

    private Integer compulsorySubjectsAllowedNumber;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ScienceSubjectService scienceSubjectService;

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private CompulsorySubjectRepository compulsorySubjectRepository;


    private void addToSetIfLessThan(Integer compulsorySubjectsNumber, CompulsorySubject compulsorySubject, Set<CompulsorySubject> allCompulsorySubject) {

        if (compulsorySubjectsAllowedNumber < compulsorySubjectsMaxNumber) {
            allCompulsorySubject.add(compulsorySubject);

        }
    }


    @Override
    public void setCompulsorySubjectGrade(Set<CompulsorySubject> allCompulsorySubject) {

        for (CompulsorySubject compulsorySubject : allCompulsorySubject) {

            Integer subjectScore = (int) compulsorySubject.getStudentScore();
            String subjectScoreGrade = calculationService.subjectScoreGrade(subjectScore);
            compulsorySubject.setScoreGrade(subjectScoreGrade);


        }
    }


    @Override
    public void setCompulsoryGradePoints(Set<CompulsorySubject> allCompulsorySubject) {
        for (CompulsorySubject compulsorySubject : allCompulsorySubject) {

            String subjectGrade = compulsorySubject.getScoreGrade();
            Double gradePoints = calculationService.subjectScorePoints(subjectGrade);
            compulsorySubject.setGradePoints(gradePoints);
            compulsorySubjectRepository.save(compulsorySubject);
            ;


        }
    }

    @Override
    public Subject findBySubjectName(String subjectName) {
        Subject askedSubject = compulsorySubjectRepository.findBySubjectName(subjectName);

        return askedSubject;
    }


}