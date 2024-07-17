package com.ironhack.gradesdataservice;

import com.ironhack.gradesdataservice.model.Course;
import com.ironhack.gradesdataservice.model.Grade;
import com.ironhack.gradesdataservice.repository.CourseRepository;
import com.ironhack.gradesdataservice.repository.GradeRepository;
import com.ironhack.gradesdataservice.service.impl.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
@EnableEurekaClient
public class GradesDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradesDataServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CourseRepository courseRepository, GradeRepository gradeRepository, CourseService courseService) {
		return args -> {

			courseRepository.save(new Course("CS101","Intro to Java",new ArrayList<>()));
			courseRepository.save(new Course("CS103","Intro to SQL",new ArrayList<>()));
			gradeRepository.save(new Grade(null,5,"s1"));
			gradeRepository.save(new Grade(null,3,"s1"));

			courseService.addGradeToCourse(1, "CS101");
			courseService.addGradeToCourse(2, "CS101");


		};
	}

}
