package com.example.test3json.controller;

import com.example.test3json.model.Chapter;
import com.example.test3json.model.Course;
import com.example.test3json.repository.ChaptersRepository;
import com.example.test3json.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chapters")
@Component
public class ChapterController {
    @Autowired
    private ChaptersRepository chaptersRepository;
    private CourseRepository courseRepository;

    @Autowired
    public ChapterController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

//    public ChapterController() throws IOException {
//    }

    @GetMapping("/{courseId}/chapters/ro")
    public List<Chapter> getChaptersByCourseIdRo(@PathVariable Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        return chaptersRepository.findByCourseIdRo(courseId);

    }
    @GetMapping("/{courseId}/chapters/en")
    public List<Chapter> getChaptersByCourseIdRn(@PathVariable Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        return chaptersRepository.findByCourseIdEn(courseId);
    }


    @GetMapping
    public List<Chapter> getAllChapters() {
        return chaptersRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/en")
    public List<Chapter> getAllChaptersWithEnglishName() {
        return chaptersRepository.findAllChaptersWithEnglishName();
    }

    @GetMapping("/ro")
    public List<Chapter> getAllChaptersWithRomanianName() {
        return chaptersRepository.findAllChaptersWithRomanianName();
    }

    @GetMapping("/{id}/ro")
    public Chapter getChapterByIdRo(@PathVariable Long id) {
        return chaptersRepository.findChapterByIdWithSelectedFieldsRo(id);
    }

    @GetMapping("/{id}/en")
    public Chapter getChapterByIdEn(@PathVariable Long id) {
        return chaptersRepository.findChapterByIdWithSelectedFieldsEn(id);
    }


}

