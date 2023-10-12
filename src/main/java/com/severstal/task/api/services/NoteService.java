package com.severstal.task.api.services;

import com.severstal.task.api.domain.entities.Note;
import com.severstal.task.api.domain.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    public Optional<Note> findById(Integer id) {
        return noteRepository.findById(id);
    }

    public List<Note> readNotes() {
        return noteRepository.findAll();
    }

    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }
}
