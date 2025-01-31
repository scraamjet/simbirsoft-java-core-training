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
        return students.stream().collect(Collectors.groupingBy(
                Student::getGroupNumber,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Map<String, Double> avgGrades = new HashMap<>();
                            list.get(0).getGrades().keySet().forEach(subject -> {
                                double avg = list.stream().mapToInt(s -> s.getGrades().get(subject)).average().orElse(0);
                                double roundedAvg = Math.round(avg * 10.0) / 10.0;
                                avgGrades.put(subject, roundedAvg);
                            });
                            return avgGrades;
                        }
                )
        ));
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