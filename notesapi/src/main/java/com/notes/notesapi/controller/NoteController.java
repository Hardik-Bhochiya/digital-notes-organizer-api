package com.notes.notesapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.notes.notesapi.entity.Note;
import com.notes.notesapi.service.Noteservice;
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private Noteservice service;
    //create note
    @PostMapping
    public Note createNote(@RequestBody Note note){
        return service.createNote(note);
    }
    //get aall notes
    @GetMapping
    public List<Note>getAllNotes(){
        return service.getAllNotes();
    }
    //Delete Note
    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id){
        return service.deleteNote(id);
    }
    //Update note
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id,@RequestBody Note note){
        return service.updateNote(id,note);
    }
}
