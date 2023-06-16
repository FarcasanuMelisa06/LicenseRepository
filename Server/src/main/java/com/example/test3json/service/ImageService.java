package com.example.test3json.service;

import com.example.test3json.model.Chapter;
import com.example.test3json.repository.ChaptersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

//    private final ChaptersRepository chapterRepository;
//
//    @Autowired
//    public ImageService(ChaptersRepository chapterRepository) {
//        this.chapterRepository = chapterRepository;
//    }
//
//    public void saveImage(Long chapterId, MultipartFile imageFile) throws IOException {
//        Chapter chapter = chapterRepository.findById(chapterId).orElseThrow(() -> new IllegalArgumentException("Capitolul nu a fost găsit."));
//        chapter.setImage(imageFile.getBytes());
//        chapterRepository.save(chapter);
//    }
//
//    public byte[] getImage(Long chapterId) {
//        Chapter chapter = chapterRepository.findById(chapterId).orElseThrow(() -> new IllegalArgumentException("Capitolul nu a fost găsit."));
//        return chapter.getImage();
//    }
}

