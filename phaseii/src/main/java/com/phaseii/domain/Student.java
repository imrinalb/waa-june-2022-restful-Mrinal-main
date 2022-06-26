package com.phaseii.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String major;

    private double gpa;

    private List<Course> coursesTaken;

    private boolean deleted;

    public Student(Long id, String firstName, String lastName, String email, String major){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.coursesTaken = new ArrayList<>();
    }

    public Student(Long id, String firstName, String lastName, String email, String major,double gpa, List<Course> coursesTaken){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa= gpa;
        this.coursesTaken = coursesTaken;
    }

    public Student(Long id, String firstName, String lastName, String email, String major, List<Course> coursesTaken){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.coursesTaken = coursesTaken;
    }

    public void addCourse(Course course){
        this.coursesTaken.add(course);
    }
}
