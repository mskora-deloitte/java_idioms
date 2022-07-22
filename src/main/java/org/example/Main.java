package org.example;

import org.example.course.Course;
import org.example.department.Department;
import org.example.student.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // ************************************************************************
        // Data initialization
        List<Student> students = new ArrayList<>(List.of(
                new Student("A", "Aa", "0000", 20, Student.Gender.MALE),
                new Student("B", "Bb", "0001", 26, Student.Gender.FEMALE),
                new Student("C", "Cc", "0002", 19, Student.Gender.MALE),
                new Student("D", "Dd", "0003", 25, Student.Gender.FEMALE),
                new Student("E", "Ee", "0004", 20, Student.Gender.MALE),
                new Student("F", "Ff", "0005", 24, Student.Gender.MALE),
                new Student("G", "Gg", "0006", 19, Student.Gender.FEMALE),
                new Student("H", "Hh", "0007", 23, Student.Gender.MALE),
                new Student("I", "Ii", "0008", 21, Student.Gender.FEMALE),
                new Student("J", "Jj", "0009", 22, Student.Gender.FEMALE)
        ));
        List<Department> departments = new ArrayList<>(List.of(
                new Department("W01", students.stream().limit(students.size() / 2).collect(Collectors.toSet())),
                new Department("W02", students.stream().skip(students.size() / 2).collect(Collectors.toSet()))
        ));
        students.stream().limit(students.size() / 2).forEach(student -> student.setDepartment(departments.get(0)));
        students.stream().skip(students.size() / 2).forEach(student -> student.setDepartment(departments.get(1)));

        List<Course> courses = new ArrayList<>(List.of(
                new Course("Matematyka 1", "01C"),
                new Course("Matematyka 1", "01W"),
                new Course("Fizyka", "02C"),
                new Course("Fizyka", "02W"),
                new Course("Fizyka", "02L"),
                new Course("Informatyka 1", "03C"),
                new Course("Informatyka 1", "03W"),
                new Course("Architektura komputerów 1", "04C"),
                new Course("Architektura komputerów 1", "04W"),
                new Course("Bazy danych 1", "05C"),
                new Course("Bazy danych 1", "05W"),
                new Course("Bazy danych 1", "05L"),
                new Course("Matematyka 2", "06C"),
                new Course("Matematyka 2", "06W"),
                new Course("Informatyka 2", "07C"),
                new Course("Informatyka 2", "07W"),
                new Course("Informatyka 2", "07L"),
                new Course("Bazy danych 2", "08W"),
                new Course("Bazy danych 2", "08L"),
                new Course("Architektura komputerów 2", "09C"),
                new Course("Architektura komputerów 2", "09W"),
                new Course("Architektura komputerów 2", "09L")
        ));
        students.stream().filter(student -> student.getAge() < 21)
                .forEach(student -> student.setCourses(courses.stream().limit(7).collect(Collectors.toSet())));
        students.stream().filter(student -> student.getAge() > 21)
                .forEach(student -> student.setCourses(courses.stream().skip(7).collect(Collectors.toSet())));
//        students.get(students.size() - 2).setCourses(courses.stream().skip(2).collect(Collectors.toSet()));
        students.get(students.size() - 2).setCourses(courses.stream().skip(2).collect(Collectors.toSet()));
        // **************************************************************************

        // Filtering objects of chosen class
        // Printing students older than 21 years
        System.out.println("STUDENTS OLDER THAN 21 YEARS");
        students.stream().filter(student -> student.getAge() > 21).forEach(System.out::println);

        // Printing department for each student (Map)
        System.out.println("\nDEPARTMENT OF EACH STUDENT");
        students.stream().map(Student::getDepartment).forEach(System.out::println);

        // Printing students with most courses assigned (min/max)
        System.out.println("\nSTUDENT ATTENDING TO MOST COURSES");
        students.stream().max(Comparator.comparingInt(student -> student.getCourses().size())).ifPresent(System.out::println);

        // Calculating average age of students
        System.out.println("\nAVERAGE AGE OF STUDENTS");
        System.out.println(students.stream().collect(Collectors.averagingInt(Student::getAge)));
    }
}