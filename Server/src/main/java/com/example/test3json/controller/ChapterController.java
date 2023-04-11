package com.example.test3json.controller;

import com.example.test3json.model.Chapter;
import com.example.test3json.repository.ChaptersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {
    @Autowired
    private ChaptersRepository chaptersRepository;

    @GetMapping()
    public List<Chapter> getCapitole() {
        return chaptersRepository.findAll();
    }

//    @GetMapping("/{id}/en")
//    public ResponseEntity<Chapter> getChapterById(@PathVariable Long id) {
//        Optional<Chapter> chapterOptional = chaptersRepository.findById(id);
//        if (chapterOptional.isPresent()) {
//            return ResponseEntity.ok(chapterOptional.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

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
