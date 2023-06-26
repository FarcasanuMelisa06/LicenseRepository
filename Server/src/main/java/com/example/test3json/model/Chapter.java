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
    @Column(name = "videoid",nullable = false)
    private String videoid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Chapter(){

    }

    public Chapter(Long id, String name, String content, String initialdescription, String image, String videoid){
        this.id = id;
        this.name = name;
        this.content = content;
        this.initialdescription = initialdescription;
        this.image = image;
        this.videoid = videoid;
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

    public String getVideoid() {
        return videoid;
    }
    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
}
