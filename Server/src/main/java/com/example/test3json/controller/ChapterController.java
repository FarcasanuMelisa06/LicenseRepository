package com.example.test3json.controller;

import com.example.test3json.model.Chapter;
import com.example.test3json.repository.ChaptersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/chapters")
@Component
public class ChapterController {
    @Autowired
    private ChaptersRepository chaptersRepository;

    public ChapterController() throws IOException {
    }


    @GetMapping
    public List<Chapter> getAllChapters() {
        return chaptersRepository.findAllByOrderByIdAsc();
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
//    @PostMapping("/{nume}")
//    public Chapter addImageToChapter(@PathVariable("nume") String nume, @RequestParam("imagine") MultipartFile imagine) {
//        Chapter chapter = chaptersRepository.findByNume(nume);
//        try {
//            byte[] imageContent = imagine.getBytes();
//            chapter.setImage(imageContent);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return chaptersRepository.save(chapter);
//    }

//    @PostMapping("/{id}/image")
//    public ResponseEntity<String> uploadImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile imageFile) {
//        try {
//            // Verifică dacă capitolul există în baza de date
//            Chapter chapter = chaptersRepository.findById(id).orElse(null);
//            if (chapter == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Capitolul nu a fost găsit.");
//            }
//
//            // Verifică dacă fișierul este o imagine
//            if (!imageFile.getContentType().startsWith("image/jpeg")) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fișierul nu este o imagine validă.");
//            }
//
//            // Obține datele imaginii
//            byte[] imageData = imageFile.getBytes();
//
//            // Salvează datele imaginii în obiectul Chapter
//            chapter.setImage(imageData);
//
//            // Salvează obiectul Chapter actualizat în baza de date
//            chaptersRepository.save(chapter);
//
//            return ResponseEntity.ok("Imaginea a fost încărcată cu succes.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Eroare la încărcarea imaginii.");
//        }
//    }
}

