package com.ironhack.gradesdataservice.service.interfaces;


import com.ironhack.gradesdataservice.DTO.CourseGrade;

public interface CourseServiceInterface {
    CourseGrade getCourseGrades(String courseCode);
}
