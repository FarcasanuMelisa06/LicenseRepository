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

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "image",nullable = false)
    private String image;

    @Column(name = "initialdescription",nullable = false)
    private String initialdescription;


    public Chapter(){

    }

    public Chapter(Long id, String name, String content, String image, String initialdescription){
        this.id = id;
        this.name = name;
        this.content = content;
        this.image = image;
        this.initialdescription = initialdescription;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
