package com.ironhack.studentcatalogservice.controller;

import com.ironhack.studentcatalogservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/catalogs/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalogByCourseCode(@PathVariable String courseCode) {

        Course course = restTemplate.getForObject("http://grades-data-service/api/courses/"+courseCode, Course.class);
        if(course == null) {
            throw new RuntimeException("Course not found");
        }
        String courseName = course.getCourseName();

        List<Grade> grades = new ArrayList<>();
        List<Student> students=new ArrayList<>();
        for(Grade grade : course.getGrades()) {
              Student student = restTemplate.getForObject("http://student-info-service/api/students/"+grade.getStudentId(), Student.class);
              if(student == null) {
                  throw new RuntimeException("Student not found");
              }
              students.add(student);
              grades.add(grade);
        }
        List<StudentGrade> studentGrades = new ArrayList<>();
        for(int i=0;i<grades.size();i++){
            studentGrades.add(new StudentGrade(students.get(i).getName(),students.get(i).getAge(),grades.get(i)));
        }

        return new Catalog(courseName, studentGrades);
    }
}