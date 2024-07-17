package com.ironhack.gradesdataservice.repository;

import com.ironhack.gradesdataservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade,Integer> {
    List<Grade> findByStudentId(String studentId);
}
