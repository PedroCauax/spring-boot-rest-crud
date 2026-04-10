package com.restapi.java.rest;

import org.springframework.web.bind.annotation.RestController;

import com.restapi.java.entity.Student;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("Jane", "Smith"));
        students.add(new Student("Michael", "Johnson"));
    }



    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }
    
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // Implementation for fetching a specific student by ID
        if((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    } 
}

