package com.example.simbirsoft_java_core_training.classes.Task6;

import java.util.*;

class Applicant {
    private String firstName;
    private String lastName;
    private Map<String, Integer> examScores = new HashMap<>();

    public Applicant(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void takeExam(String subject, int score) {
        examScores.put(subject, score);
    }

    public double getAverageScore() {
        return examScores.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}

