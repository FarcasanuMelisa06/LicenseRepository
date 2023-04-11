package com.example.test3json.repository;

import com.example.test3json.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT new com.example.test3json.model.Course(c.id, c.nameEn) FROM Course c")
    List<Course> findAllCoursesWithEnglishName();

    @Query("SELECT new com.example.test3json.model.Course(c.id, c.name)FROM Course c")
    List<Course> findAllCoursesWithRomanianName();

}
