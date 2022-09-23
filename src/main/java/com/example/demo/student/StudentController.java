package com.example.demo.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    
    private static final List<Student> STUDENTS = Arrays.asList(
        new Student(1,"JunXian428"),
        new Student(2,"Hello Worl"),
        new Student(3,"Hello World")
    );

    @GetMapping(path= "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentID){
        return STUDENTS.stream().filter(student-> studentID.equals(student.getStudentId()))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Student " + studentID + "does not exist"));
    }
}
