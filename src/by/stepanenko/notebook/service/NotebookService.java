package by.stepanenko.notebook.service;

import java.time.LocalDate;
import java.util.List;
import by.stepanenko.notebook.entity.Note;

public interface NotebookService {

	void createNewFile();

	void add(Note n);

	List<Note> find(String text);

	List<Note> find(LocalDate date);

	List<Note> allNotes();

	void save();

	void updateNoteByID(String id, String newValue);
}
