package com.springSecurity.SecurityApplication.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/management/students")
public class StudentManagementController {
    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Pam Beesly"),
            new Student(2, "Jim Halpert"),
            new Student(3, "Andy Bernard")
    );
    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return STUDENTS;
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);
    }
    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }
    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId,@RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", studentId, student));
    }
}
