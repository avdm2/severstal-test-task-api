package com.severstal.task.api.controllers;

import com.severstal.task.api.domain.dto.NoteDto;
import com.severstal.task.api.domain.entities.Note;
import com.severstal.task.api.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/create")
    public ResponseEntity<Note> createNote(@RequestBody NoteDto noteDto) {
        if (noteDto.getTitle() == null || noteDto.getDescription() == null) {
            return new ResponseEntity<>(new Note(), HttpStatus.BAD_REQUEST);
        }

        Note note = new Note()
                .setTitle(noteDto.getTitle())
                .setDescription(noteDto.getDescription())
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now());

        noteService.saveNote(note);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Integer id) {
        Optional<Note> note = noteService.findById(id);
        return note.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new Note(), HttpStatus.BAD_REQUEST));

    }

    @GetMapping("/get")
    public ResponseEntity<List<Note>> getNotes() {
        List<Note> notes = noteService.readNotes();
        return new ResponseEntity<>(notes, notes.isEmpty() ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Integer id, @RequestBody NoteDto noteDto) {
        if (noteDto.getTitle() == null && noteDto.getDescription() == null) {
            return new ResponseEntity<>(new Note(), HttpStatus.BAD_REQUEST);
        }

        Optional<Note> optionalNote = noteService.findById(id);
        if (optionalNote.isEmpty()) {
            return new ResponseEntity<>(new Note(), HttpStatus.BAD_REQUEST);
        }

        Note note = optionalNote.get();
        if (noteDto.getTitle() != null) {
            note.setTitle(noteDto.getTitle());
        }
        if (noteDto.getDescription() != null) {
            note.setDescription(noteDto.getDescription());
        }
        note.setUpdatedAt(LocalDateTime.now());
        noteService.saveNote(note);

        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Integer id) {
        Optional<Note> optionalNote = noteService.findById(id);
        if (optionalNote.isEmpty()) {
            return new ResponseEntity<>(new Note(), HttpStatus.BAD_REQUEST);
        }

        Note note = optionalNote.get();
        noteService.deleteNote(note);

        return new ResponseEntity<>(note, HttpStatus.OK);
    }
}
