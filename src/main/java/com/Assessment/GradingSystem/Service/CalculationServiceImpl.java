package com.Assessment.GradingSystem.Service;

import com.Assessment.GradingSystem.Entity.CompulsorySubject;
import com.Assessment.GradingSystem.Entity.OptionalSubject;
import com.Assessment.GradingSystem.Entity.ScienceSubject;
import com.Assessment.GradingSystem.Repository.CompulsorySubjectRepository;
import com.Assessment.GradingSystem.Repository.OptionalSubjectRepository;
import com.Assessment.GradingSystem.Repository.SciencesSubjectRepository;
import com.Assessment.GradingSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author wayne
 * @Date 03/05/2023
 */
@Service
public class CalculationServiceImpl implements CalculationService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CompulsorySubjectRepository compulsorySubjectRepository;

    @Autowired
    private SciencesSubjectRepository sciencesSubjectRepository;

    @Autowired
    private OptionalSubjectRepository optionalSubjectRepository;


    @Override
    public Double getTotalMarks(StudentRequest studentRequest, Long studentId) {

        Optional<CompulsorySubject> allCompulsorySubjects = compulsorySubjectRepository.findById(studentId);
        Optional<ScienceSubject> allScienceSubjects = sciencesSubjectRepository.findById(studentId);
        Optional<OptionalSubject> allOptionalSubjects = optionalSubjectRepository.findById(studentId);

        Double compulsorySum = allCompulsorySubjects.stream().mapToDouble(CompulsorySubject::getStudentScore).sum();
        Double scienceSum = addScienceSubjectsTotalMarks(allScienceSubjects);
        Double optionSum = allOptionalSubjects.stream().mapToDouble(OptionalSubject::getStudentScore).sum();

        Double totalMarks = compulsorySum + optionSum + scienceSum;
        studentRequest.setTotalMarks(totalMarks);
        return totalMarks;
    }

    public Double getTotalPoints(StudentRequest studentRequest, Long studentId) {

        Optional<CompulsorySubject> allCompulsorySubjects = compulsorySubjectRepository.findById(studentId);
        Optional<ScienceSubject> allScienceSubjects = sciencesSubjectRepository.findById(studentId);
        Optional<OptionalSubject> allOptionalSubject = optionalSubjectRepository.findById(studentId);

        Double compulsoryPoints = allCompulsorySubjects.stream().mapToDouble(CompulsorySubject::getGradePoints).sum();
        Double sciencePoints = allScienceSubjects.stream().mapToDouble(ScienceSubject::getGradePoints).sum();
        Double optionPoints = allOptionalSubject.stream().mapToDouble(OptionalSubject::getGradePoints).sum();

        Double totalPoints = compulsoryPoints + sciencePoints + optionPoints;

        return totalPoints;

    }


    public String subjectScoreGrade(Integer subjectScore) {

        String letterGrade = null;
        if (subjectScore <= 100 && subjectScore >= 95) {
            letterGrade = "A";
        } else if (subjectScore >= 89) {
            letterGrade = "A-";
        } else if (subjectScore >= 83) {
            letterGrade = "B+";
        } else if (subjectScore >= 76) {
            letterGrade = "B";
        } else if (subjectScore >= 69) {
            letterGrade = "B-";
        } else if (subjectScore >= 61) {
            letterGrade = "C+";
        } else if (subjectScore >= 53) {
            letterGrade = "C";
        } else if (subjectScore >= 44) {
            letterGrade = "C-";
        } else if (subjectScore >= 36) {
            letterGrade = "D+";
        } else if (subjectScore >= 28) {
            letterGrade = "D";
        } else if (subjectScore >= 21) {
            letterGrade = "D-";
        } else if (subjectScore >= 0) {
            letterGrade = "E";
        }

        return letterGrade;

    }

    public Double subjectScorePoints(String grade) {
        double points = 0;

        if (grade == "A") {
            points = 12;
        } else if (grade == "A-") {
            points = 11;
        } else if (grade == "B+") {
            points = 10;
        } else if (grade == "B") {
            points = 9;
        } else if (grade == "B-") {
            points = 8;
        } else if (grade == "C+") {
            points = 7;
        } else if (grade == "C") {
            points = 6;
        } else if (grade == "C-") {
            points = 5;
        } else if (grade == "D+") {
            points = 4;
        } else if (grade == "D") {
            points = 3;
        } else if (grade == "D-") {
            points = 2;
        } else if (grade == "E") {
            points = 1;
        }

        return points;
    }

    @Override
    public Double subjectMean(String subjectName) {

        return null;
    }

    public String finalGradePoints(Double meanPoints) {

        String finalGrade = null;


        if (meanPoints < 1.5) {
            finalGrade = "E";
        } else if ((1.5 <= meanPoints) && meanPoints < 2.5) {
            finalGrade = "D-";
        } else if ((2.5 <= meanPoints) && meanPoints < 3.5) {
            finalGrade = "D";
        } else if ((3.5 <= meanPoints) && meanPoints < 4.5) {
            finalGrade = "D+";
        } else if ((4.5 <= meanPoints) && meanPoints < 5.5) {
            finalGrade = "C-";
        } else if ((5.5 <= meanPoints) && meanPoints < 6.5) {
            finalGrade = "C";
        } else if ((6.5 <= meanPoints) && meanPoints < 7.5) {
            finalGrade = "C+";
        } else if ((7.5 <= meanPoints) && meanPoints < 8.5) {
            finalGrade = "B-;";
        } else if ((8.5 <= meanPoints) && meanPoints < 9.5) {
            finalGrade = "B";
        } else if ((9.5 <= meanPoints) && meanPoints < 10.5) {
            finalGrade = "B+";
        } else if ((10.5 <= meanPoints) && meanPoints < 11.5) {
            finalGrade = "A-";
        } else if (meanPoints >= 11.5) {
            finalGrade = "A";
        }

        return finalGrade;
    }

    @Override
    public String getFinalGrade(Double totalPoints) {
        CompulsorySubject compulsorySubject = new CompulsorySubject();
        ScienceSubject scienceSubject = new ScienceSubject();
        OptionalSubject optionalSubject = new OptionalSubject();

        Double totalGradePoints = compulsorySubject.getGradePoints() + scienceSubject.getGradePoints() +
                optionalSubject.getGradePoints();

        Double meanPoints = totalGradePoints / 7;


        return finalGradePoints(meanPoints);
    }

    public Double addScienceSubjectsTotalMarks(Optional<ScienceSubject> allScienceSubjects) {
        Set<ScienceSubject> scienceSet = new TreeSet<>(Comparator.comparing(ScienceSubject::getStudentScore));

        Set<ScienceSubject> sortedSet = scienceSet.stream()
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(ScienceSubject::getStudentScore))));

        Double sum = (sortedSet.stream().limit(2).toList()).stream().mapToDouble(ScienceSubject::getStudentScore).sum();

        return sum;
    }
}
