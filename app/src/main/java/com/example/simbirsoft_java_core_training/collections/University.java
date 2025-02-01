package com.example.simbirsoft_java_core_training.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class University {
    private List<Student> students;

    public University(List<Student> students) {
        this.students = students;
    }

    public void sortStudentsByCourseAndName() {
        students.sort(Comparator.comparingInt(Student::getCourse).thenComparing(Student::getLastName));
    }

    public Map<Integer, Map<String, Double>> calculateAverageGradesByGroup() {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroupNumber,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                this::calculateAverageGrades
                        )
                ));
    }

    private Map<String, Double> calculateAverageGrades(List<Student> students) {
        Map<String, Double> avgGrades = new HashMap<>();
        if (!students.isEmpty()) {
            students.get(0).getGrades().keySet().forEach(subject -> {
                double avg = calculateSubjectAverage(students, subject);
                double roundedAvg = roundToOneDecimal(avg);
                avgGrades.put(subject, roundedAvg);
            });
        }
        return avgGrades;
    }

    private double calculateSubjectAverage(List<Student> students, String subject) {
        return students.stream()
                .mapToInt(s -> s.getGrades().get(subject))
                .average()
                .orElse(0);
    }

    private double roundToOneDecimal(double value) {
        return Math.round(value * 10.0) / 10.0;
    }

    public Student getOldestStudent() {
        return students.stream().min(Comparator.comparingInt(Student::getBirthYear)).orElse(null);
    }

    public Student getYoungestStudent() {
        return students.stream().max(Comparator.comparingInt(Student::getBirthYear)).orElse(null);
    }

    public Map<Integer, Student> getBestStudentsByGroup() {
        return students.stream().collect(Collectors.toMap(Student::getGroupNumber, Function.identity(), BinaryOperator.maxBy(Comparator.comparingDouble(Student::getAverageGrade))));
    }
}