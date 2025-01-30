package by.stepanenko.notebook.dao;

import by.stepanenko.notebook.entity.Note;
import java.util.List;

public interface NoteBookDao {
    List<Note> allNotes();
    void addNote(Note note);
    void createNewFile();
    void save();
    void updateNoteByID(String id, String newValue);

}
