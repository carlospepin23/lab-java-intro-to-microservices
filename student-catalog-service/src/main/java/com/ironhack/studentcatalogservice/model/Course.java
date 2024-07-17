package com.ironhack.studentcatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String courseCode;
    private String courseName;
    private List<Grade> grades;
}
