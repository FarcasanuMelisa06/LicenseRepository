package com.example.test3json.model;

import jakarta.persistence.*;

@Entity  //entitate JPA care va fi mapata in tabela de date
@Table(name = "users") //numele tabelei
public class User {
    @Id //cheia primara
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    public User(){
    }
    //constructor care initializeaza obiectele cu valorile corespunzatoare
    public User(Long id, String username, String password, String token){
        this.id = id;
        this.username = username;
        this.password = password;

    }
    //metodele getter si setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
