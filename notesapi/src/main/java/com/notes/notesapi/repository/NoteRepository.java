package com.notes.notesapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.notes.notesapi.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
    
}