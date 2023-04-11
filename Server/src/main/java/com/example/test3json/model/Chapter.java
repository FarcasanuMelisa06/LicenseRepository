package com.example.test3json.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nameen", nullable = false)
    private String nameEn;

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "contenten",nullable = false)
    private String contentEn;

    @Column(name = "image",nullable = false)
    private String image;

    @Column(name = "initialdescription",nullable = false)
    private String initialdescription;

    @Column(name = "initialdescriptionen",nullable = false)
    private String initialdescriptionEn;

    public Chapter(){

    }

//    public Chapter(Long id, String nameRo,String nameEn,
//                   String contentRo,String contentEn,
//                   String image, String initialdescriptionRo, String initialdescriptionEn){
//        this.id = id;
//        this.nameRo = nameRo;
//        this.nameEn = nameEn;
//        this.contentRo = contentRo;
//        this.contentEn = contentEn;
//        this.image = image;
//        this.initialdescriptionRo = initialdescriptionRo;
//        this.initialdescriptionEn = initialdescriptionEn;
//    }

//    public Chapter(Long id, String nameEn, String contentEn, String initialdescriptionEn, String image){
//        this.id = id;
//        this.nameEn = nameEn;
//        this.contentEn = contentEn;
//        this.initialdescriptionEn = initialdescriptionEn;
//        this.image = image;
//    }
    public Chapter(Long id,String name, String content, String initialdescription, String image){
        this.id = id;
        this.name = name;
        this.content = content;
        this.initialdescription = initialdescription;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentEn() {
        return contentEn;
    }

    public void setContentEn(String contentEn) {
        this.contentEn = contentEn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInitialdescription() {
        return initialdescription;
    }

    public void setInitialdescription(String initialdescription) {
        this.initialdescription = initialdescription;
    }

    public String getInitialdescriptionEn() {
        return initialdescriptionEn;
    }
    public void setInitialdescriptionEn(String initialdescriptionEn) {
        this.initialdescriptionEn = initialdescriptionEn;
    }
}
