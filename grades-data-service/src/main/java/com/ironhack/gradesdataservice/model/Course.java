package com.ironhack.gradesdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private String courseCode;
    private String courseName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "courses_grades",
            joinColumns = { @JoinColumn(name = "course_code")},
            inverseJoinColumns = { @JoinColumn(name = "grade_id")}
    )
    private List<Grade> grades;
}
