package com.springSecurity.SecurityApplication.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {
    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Pam Beesly"),
            new Student(2, "Jim Halpert"),
            new Student(3, "Andy Bernard")
    );
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return STUDENTS;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);
    }
    @DeleteMapping("{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }
    @PutMapping("{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId,@RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", studentId, student));
    }
}
