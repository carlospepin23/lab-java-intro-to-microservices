package com.ironhack.gradesdataservice.service.impl;

import com.ironhack.gradesdataservice.DTO.CourseGrade;
import com.ironhack.gradesdataservice.model.Course;
import com.ironhack.gradesdataservice.model.Grade;
import com.ironhack.gradesdataservice.repository.CourseRepository;
import com.ironhack.gradesdataservice.repository.GradeRepository;
import com.ironhack.gradesdataservice.service.interfaces.CourseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CourseServiceInterface {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GradeRepository gradeRepository;

    public CourseGrade getCourseGrades(String courseCode){
        Optional<Course> courseFromDb =  courseRepository.findById(courseCode);
        if(courseFromDb.isPresent()){
            List<Grade> courseGrades = courseFromDb.get().getGrades();
            return new CourseGrade(courseCode,courseGrades);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not found");
        }
    }

    public void addGradeToCourse(Integer gradeId, String courseCode) {
        Course course = courseRepository.findById(courseCode).get();
        Grade grade = gradeRepository.findById(gradeId).get();
        course.getGrades().add(grade);
        courseRepository.save(course);
    }
}
