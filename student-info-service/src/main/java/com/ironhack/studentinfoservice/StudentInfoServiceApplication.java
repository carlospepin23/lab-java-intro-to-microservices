package com.ironhack.studentinfoservice;

import com.ironhack.studentinfoservice.model.Student;
import com.ironhack.studentinfoservice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class StudentInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentInfoServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(StudentRepository studentRepository) {
        return args -> {
            studentRepository.save(new Student("s1", "John Doe", 17));
            studentRepository.save(new Student("s2", "Jane Doe", 19));
            studentRepository.save(new Student("s3", "Scott Smith", 23));
            studentRepository.save(new Student("s4", "James Bond", 27));
        };
    }
}
