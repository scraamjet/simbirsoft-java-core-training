package com.example.simbirsoft_java_core_training.education;

import java.util.Map;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private int birthYear;
    private int course;
    private int groupNumber;
    private Map<String, Integer> grades;

    public Student(int id,
                   String lastName,
                   String firstName,
                   String middleName,
                   int birthYear,
                   int course,
                   int groupNumber,
                   Map<String, Integer> grades
    ) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.course = course;
        this.groupNumber = groupNumber;
        this.grades = grades;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getCourse() {
        return course;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    @Override
    public String toString() {
        StringBuilder gradesString = new StringBuilder();
        grades.forEach((subject, grade) -> gradesString.append(subject).append(": ").append(grade).append(" "));
        return String.format("Студент: %s %s %s, Год рождения: %d, Курс: %d, Группа: %d",
                lastName, firstName, middleName, birthYear, course, groupNumber);
    }
}
