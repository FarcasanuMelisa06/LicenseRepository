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
        List<Course> courses = courseRepository.findAll();
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


//   //metoda de adaugare curs in baza de date
//    @PostMapping("/add")
//    public Course addCourse(@RequestBody Course course) {
//        return courseRepository.save(course);
//    }

//    //optinerea unui curs din baza de date cu ajutorul id-ului
//    @GetMapping("/{id}")
//    public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Long courseId) {
//        Optional<Course> optionalCourse = courseRepository.findById(courseId);
//        if (optionalCourse.isPresent()) {
//            return ResponseEntity.ok().body(optionalCourse.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    //metoda de stergere
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) {
//        Optional<Course> optionalCourse = courseRepository.findById(id);
//        if (optionalCourse.isPresent()) {
//            courseRepository.delete(optionalCourse.get());
//            return ResponseEntity.ok().body("Course with ID " + id + " deleted successfully.");
//        } else {
//            return ResponseEntity.badRequest().body("Course with ID " + id + " not found.");
//        }
//    }
//    //metoda de actualizare a unui curs din baza de date
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long courseId,
//                                               @RequestBody Course courseDetails) {
//        Optional<Course> optionalCourse = courseRepository.findById(courseId);
//        if (optionalCourse.isPresent()) {
//            Course course = optionalCourse.get();
//            course.setName(courseDetails.getName());
//            final Course updatedCourse = courseRepository.save(course);
//            return ResponseEntity.ok(updatedCourse);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//}
}
