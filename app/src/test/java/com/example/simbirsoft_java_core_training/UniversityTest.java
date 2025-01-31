package com.example.simbirsoft_java_core_training;

import com.example.simbirsoft_java_core_training.collections.Student;
import com.example.simbirsoft_java_core_training.collections.University;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.*;

public class UniversityTest {

    private static University university;
    private static List<Student> students;

    @BeforeClass
    public static void init() {
        students = Arrays.asList(
                new Student(0, "Иванов", "Иван", "Иванович", 2000, 3, 101, createGrades(5, 4, 3, 4, 5)),
                new Student(1, "Петров", "Петр", "Петрович", 1999, 2, 102, createGrades(3, 4, 5, 4, 3)),
                new Student(2, "Сидоров", "Сидр", "Сидорович", 2001, 3, 101, createGrades(4, 3, 5, 5, 4)),
                new Student(3, "Смирнов", "Сергей", "Сергеевич", 2003, 1, 103, createGrades(5, 5, 5, 5, 5)),
                new Student(4, "Кузнецов", "Алекс", "Александрович", 1998, 4, 104, createGrades(2, 3, 4, 3, 2)),
                new Student(5, "Попов", "Дмитрий", "Александрович", 2000, 3, 101, createGrades(3, 4, 4, 5, 4)),
                new Student(6, "Чернов", "Игорь", "Владимирович", 1997, 4, 104, createGrades(4, 5, 3, 5, 4)),
                new Student(7, "Николаев", "Михаил", "Сергеевич", 2003, 2, 102, createGrades(5, 4, 5, 4, 5)),
                new Student(8, "Егоров", "Роман", "Михайлович", 2001, 3, 101, createGrades(3, 3, 4, 5, 3)),
                new Student(9, "Дмитриев", "Максим", "Юрьевич", 1999, 2, 102, createGrades(4, 4, 5, 5, 5)),
                new Student(10, "Гаврилов", "Олег", "Петрович", 2002, 1, 103, createGrades(5, 4, 4, 4, 5)),
                new Student(11, "Лебедев", "Владислав", "Игоревич", 2000, 3, 101, createGrades(3, 4, 4, 3, 4)),
                new Student(12, "Федоров", "Евгений", "Викторович", 1998, 4, 104, createGrades(2, 3, 4, 2, 2)),
                new Student(13, "Голубев", "Станислав", "Сергеевич", 2001, 3, 101, createGrades(4, 5, 4, 5, 4)),
                new Student(14, "Алексеев", "Константин", "Александрович", 1996, 4, 104, createGrades(5, 5, 5, 4, 4))
        );
        university = new University(students);
    }

    private static Map<String, Integer> createGrades(int... grades) {
        Map<String, Integer> subjectGrades = new HashMap<>();
        String[] subjects = {"Математика", "Физика", "История", "Биология", "Английский"};

        for (int i = 0; i < subjects.length; i++) {
            subjectGrades.put(subjects[i], grades[i]);
        }

        return subjectGrades;
    }

    @Test
    public void testSortStudentsByCourseAndName() {
        university.sortStudentsByCourseAndName();
        students.forEach(System.out::println);
        int[] sortedId = {10, 3, 9, 7, 1, 13, 8, 0, 11, 5, 2, 14, 4, 12, 6};

        for (int i = 0; i < students.size(); i++) {
            assertEquals(sortedId[i], students.get(i).getId());
        }
    }

    @Test
    public void testCalculateAverageGradesByGroup() {
        Map<Integer, Map<String, Double>> avgGradesByGroup = university.calculateAverageGradesByGroup();
        avgGradesByGroup.forEach((group, grades) -> System.out.println("Группа: " + group + " " + grades));
        assertNotNull(avgGradesByGroup);
        assertEquals(3.7, avgGradesByGroup.get(101).get("Математика"), 0.01);
        assertEquals(4.3, avgGradesByGroup.get(102).get("Биология"), 0.01);
    }

    @Test
    public void testGetOldestStudent() {
        Student oldest = university.getOldestStudent();
        System.out.println("Самый взрослый студент: " + oldest);
        assertNotNull(oldest);
        assertEquals(14, oldest.getId());
    }

    @Test
    public void testGetYoungestStudent() {
        Student youngest = university.getYoungestStudent();
        System.out.println("Самый молодой студент: " + youngest);
        assertNotNull(youngest);
        assertEquals(3, youngest.getId());
    }

    @Test
    public void testGetBestStudentsByGroup() {
        Map<Integer, Student> bestStudents = university.getBestStudentsByGroup();
        bestStudents.forEach((group, student) -> System.out.println("Лучший студент в группе " + group + ": " + student));
        assertNotNull(bestStudents);
        assertEquals(13, bestStudents.get(101).getId());
        assertEquals(7, bestStudents.get(102).getId());
        assertEquals(3, bestStudents.get(103).getId());
        assertEquals(14, bestStudents.get(104).getId());
    }
}

