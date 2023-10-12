package com.severstal.task.api.domain.repositories;

import com.severstal.task.api.domain.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
