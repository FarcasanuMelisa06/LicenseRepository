package com.example.test3json.controller;

import com.example.test3json.model.Chapter;
import com.example.test3json.repository.ChaptersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {
    @Autowired
    private ChaptersRepository chaptersRepository;

    @GetMapping()
    public List<Chapter> getCapitole() {
        return chaptersRepository.findAll();
    }


}
