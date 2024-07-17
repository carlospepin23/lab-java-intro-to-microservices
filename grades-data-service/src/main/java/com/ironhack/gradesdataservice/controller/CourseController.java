package com.ironhack.gradesdataservice.controller;

import com.ironhack.gradesdataservice.DTO.CourseGrade;
import com.ironhack.gradesdataservice.model.Course;
import com.ironhack.gradesdataservice.repository.CourseRepository;
import com.ironhack.gradesdataservice.service.interfaces.CourseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseServiceInterface courseService;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseById(@PathVariable String courseCode) {
        return courseRepository.findById(courseCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong course id"));
    }

    @GetMapping("/courses/{courseCode}/grades")
    @ResponseStatus(HttpStatus.OK)
    public CourseGrade getCourseGrades(@PathVariable String courseCode) {
        return courseService.getCourseGrades(courseCode);
    }
}
