package com.notes.notesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notes.notesapi.entity.Note;
import com.notes.notesapi.entity.User;
import com.notes.notesapi.repository.NoteRepository;
import com.notes.notesapi.repository.UserRepository;

@Service
public class Noteservice{

    @Autowired
    private NoteRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userSerivce;
    // Create Note (with user association)
    public Note createNote(Note note) {

        Object userService;
        // Demo mate user id = 1 use kariye
        User user = userSerivce.getCurrentUSer();

        note.setUser(user);

        return repo.save(note);
    }

    // Get All Notes
    public List<Note> getAllNotes() {
        return repo.findAll();
    }

    // Delete Note
    public String deleteNote(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Note deleted successfully";
        } else {
            return "Note not found";
        }
    }

    // Update Note
    public Note updateNote(Long id, Note note) {

        Note existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        existing.setTitle(note.getTitle());
        existing.setContent(note.getContent());
        existing.setImportant(note.isImportant());

        return repo.save(existing);
    }
}