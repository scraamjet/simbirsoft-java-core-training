package com.example.simbirsoft_java_core_training.classes.Task6;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class Faculty {
    private String name;
    private List<Applicant> applicants = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private int passingScore;

    public Faculty(String name, int passingScore) {
        this.name = name;
        this.passingScore = passingScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void registerApplicant(Applicant applicant) {
        assignGradesToApplicant(applicant);
        applicants.add(applicant);
    }

    private void assignGradesToApplicant(Applicant applicant) {
        for (Teacher teacher : teachers) {
            if (!applicant.getExamScores().containsKey(teacher.getSubject())) {
                teacher.gradeExam(applicant, 0);
            }
        }
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Applicant> getAcceptedApplicants() {
        List<Applicant> accepted = new ArrayList<>();

        for (Applicant applicant : applicants) {
            if (applicant.getAverageScore() >= passingScore) {
                accepted.add(applicant);
            }
        }
        return accepted;
    }
}