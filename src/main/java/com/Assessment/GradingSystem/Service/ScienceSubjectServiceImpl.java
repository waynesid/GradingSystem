package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.ScienceSubject;
import com.Assessment.GradingSystem.Entity.Subject;
import com.Assessment.GradingSystem.Repository.SciencesSubjectRepository;
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
public class ScienceSubjectServiceImpl implements ScienceSubjectService {


    @Value("${science.subjects.max.number}")
    private Integer scienceSubjectsMaxNumber;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private SciencesSubjectRepository sciencesSubjectRepository;


    private void addToSetIfLessThan(Integer scienceSubjectsNumber, ScienceSubject scienceSubject, Set<ScienceSubject> allScienceSubject) {

        if (scienceSubjectsMaxNumber < scienceSubjectsNumber) {
            allScienceSubject.add(scienceSubject);

        }
    }
    /*
    sorted the set and chose the highest two science subjects to be added in the total marks
     */


    @Override
    public void setSciencesSubjectGrade(Set<ScienceSubject> allScienceSubject) {

        for (ScienceSubject scienceSubject : allScienceSubject) {

            Integer subjectScore = (int) scienceSubject.getStudentScore();
            String subjectScoreGrade = calculationService.subjectScoreGrade(subjectScore);
            scienceSubject.setScoreGrade(subjectScoreGrade);
        }
    }

    @Override
    public void setScienceGradePoints(Set<ScienceSubject> allScienceSubject) {
        for (ScienceSubject scienceSubject : allScienceSubject) {

            String subjectGrade = scienceSubject.getScoreGrade();
            Double gradePoints = calculationService.subjectScorePoints(subjectGrade);
            scienceSubject.setGradePoints(gradePoints);
        }
    }

    @Override
    public Subject findBySubjectName(String subjectName) {
        Subject askedSubject = sciencesSubjectRepository.findBySubjectName(subjectName);

        return askedSubject;

    }


}
