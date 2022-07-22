package org.example.department;

import org.example.student.Student;

import java.util.Set;

public class Department {
    private String name;
    private Set<Student> students;

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
