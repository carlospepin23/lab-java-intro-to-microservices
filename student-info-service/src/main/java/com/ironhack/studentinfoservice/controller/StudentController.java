package com.ironhack.studentinfoservice.controller;

import com.ironhack.studentinfoservice.model.Student;
import com.ironhack.studentinfoservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    public StudentRepository studentRepository;

    @GetMapping("/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentInfo(@PathVariable String studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }
}
