package com.ironhack.gradesdataservice.DTO;

import com.ironhack.gradesdataservice.model.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseGrade {
    private String courseCode;
    private List<Grade> grades;
}
