package com.example.test3json.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "namero", nullable = false)
    private String nameRo;

    @Column(name = "nameen", nullable = false)
    private String nameEn;

    @Column(name = "contentro",nullable = false)
    private String contentRo;

    @Column(name = "contenten",nullable = false)
    private String contentEn;

    @Column(name = "image",nullable = false)
    private String image;

    @Column(name = "initialdescriptionro",nullable = false)
    private String initialdescriptionRo;

    @Column(name = "initialdescriptionen",nullable = false)
    private String initialdescriptionEn;

    public Chapter(){

    }

    public Chapter(Long id, String nameRo,String nameEn,
                   String contentRo,String contentEn,
                   String image, String initialdescriptionRo, String initialdescriptionEn){
        this.id = id;
        this.nameRo = nameRo;
        this.nameEn = nameEn;
        this.contentRo = contentRo;
        this.contentEn = contentEn;
        this.image = image;
        this.initialdescriptionRo = initialdescriptionRo;
        this.initialdescriptionEn = initialdescriptionEn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRo() {
        return nameRo;
    }

    public void setNameRo(String nameRo) {
        this.nameRo = nameRo;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getContentRo() {
        return contentRo;
    }

    public void setContentRo(String contentRo) {
        this.contentRo = contentRo;
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

    public String getInitialdescriptionRo() {
        return initialdescriptionRo;
    }

    public void setInitialdescriptionRo(String initialdescription) {
        this.initialdescriptionRo = initialdescriptionRo;
    }

    public String getInitialdescriptionEn() {
        return initialdescriptionEn;
    }
    public void setInitialdescriptionEn(String initialdescriptionEn) {
        this.initialdescriptionEn = initialdescriptionEn;
    }
}
