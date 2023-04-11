package com.example.test3json.repository;

import com.example.test3json.model.Chapter;
import com.example.test3json.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChaptersRepository extends JpaRepository<Chapter, Long> {


    @Query ("SELECT new com.example.test3json.model.Chapter(c.id, c.nameEn, c.contentEn, c.initialdescriptionEn, c.image) FROM Chapter c")
    List<Chapter> findAllChaptersWithEnglishName();

    @Query ("SELECT new com.example.test3json.model.Chapter(c.id, c.name, c.content, c.initialdescription, c.image) FROM Chapter c")
    List<Chapter> findAllChaptersWithRomanianName();

    @Query("SELECT new com.example.test3json.model.Chapter( c.id,c.name, c.content, c.initialdescription, c.image) FROM Chapter c WHERE c.id = :id")
    Chapter findChapterByIdWithSelectedFieldsRo(@Param("id") Long id);

    @Query("SELECT new com.example.test3json.model.Chapter(c.id, c.nameEn, c.contentEn, c.initialdescriptionEn, c.image) FROM Chapter c WHERE c.id = :id")
    Chapter findChapterByIdWithSelectedFieldsEn(@Param("id") Long id);
}
