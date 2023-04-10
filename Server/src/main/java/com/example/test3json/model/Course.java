package com.example.test3json.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "namero", nullable = false)
    private String nameRo;

    @Column(name = "nameen", nullable = false)
    private String nameEn;

    public Course(){

    }

    public Course(Long id, String nameRo, String nameEn){
        this.id = id;
        this.nameRo = nameRo;
        this.nameEn = nameEn;
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
}
