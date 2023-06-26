package com.example.test3json.controller;

import com.example.test3json.repository.CourseRepository;
import com.example.test3json.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

   // obtinerea tuturor cursurilor din baza de date
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseRepository.findAllByOrderByIdAsc();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/en")
    public List<Course> getAllCoursesWithEnglishName() {
        return courseRepository.findAllCoursesWithEnglishName();
    }
    @GetMapping("/ro")
    public List<Course> getAllCoursesWithRomanianName() {
        return courseRepository.findAllCoursesWithRomanianName();
    }


}
