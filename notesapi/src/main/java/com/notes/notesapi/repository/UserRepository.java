package com.notes.notesapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.notes.notesapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}

