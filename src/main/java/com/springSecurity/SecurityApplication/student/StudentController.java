package com.springSecurity.SecurityApplication.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Pam Beesly"),
            new Student(2, "Jim Halpert"),
            new Student(3, "Andy Bernard")
    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student " + studentId + " doesn't exist"));
    }
}
