package by.stepanenko.notebook.dao.impl;

import by.stepanenko.notebook.dao.NoteBookDao;
import by.stepanenko.notebook.entity.Note;
import java.util.List;

public class FileNoteBookDao implements NoteBookDao {
    private static final MockSource mockSource = MockSource.getInstance();

    @Override
    public List<Note> allNotes(){
        return mockSource.getAllNotes();
    }

    @Override
    public void addNote(Note n){
         mockSource.addNote(n);
    }

    @Override
    public void createNewFile(){
         mockSource.createNewFileNote();
    }

    @Override
    public void save() {
        mockSource.save();
    }

    @Override
    public void updateNoteByID(String id, String newValue) {
        mockSource.updateNoteByID(id, newValue);
    }

}
