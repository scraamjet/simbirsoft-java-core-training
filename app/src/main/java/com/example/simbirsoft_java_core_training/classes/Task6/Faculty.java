package com.example.simbirsoft_java_core_training.classes.Task6;

import java.util.List;
import java.util.ArrayList;

class Faculty {
    private String name;
    private List<Applicant> applicants = new ArrayList<>();
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
        applicants.add(applicant);
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