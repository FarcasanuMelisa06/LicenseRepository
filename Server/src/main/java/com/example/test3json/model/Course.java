package com.example.test3json.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nameen", nullable = false)
    private String nameEn;

    public Course(){

    }
//    public Course(Long id, String nameEn) {
//        this.id = id;
//        this.nameEn = nameEn;
//    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

//    public Course(Long id, String nameRo, String nameEn){
//        this.id = id;
//        this.nameRo = nameRo;
//        this.nameEn = nameEn;
//    }

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
}
