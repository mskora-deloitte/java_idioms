package org.example.student;

import org.example.course.Course;
import org.example.department.Department;

import java.util.Set;

public class Student {

    public enum Gender {
        MALE,
        FEMALE
    }

    private String name;
    private String surname;
    private String studentId;
    private Department department;
    private Set<Course> courses;
    private int age;
    private Gender gender;

    public Student() {
    }

    public Student(String name, String surname, String studentId, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentId='" + studentId + '\'' +
                ", department=" + department +
                ", courses=" + courses +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
