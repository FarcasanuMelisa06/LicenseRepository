package com.example.test3json.repository;

import com.example.test3json.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //returnează un obiect de tip User
    //dacă există un utilizatorul in baza de date sau null daca nu exista
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
