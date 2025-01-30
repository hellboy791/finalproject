package by.stepanenko.notebook.dao;

import by.stepanenko.notebook.dao.impl.FileNoteBookDao;

public final class NoteBookProvider {

    private static final NoteBookProvider instance = new NoteBookProvider();

    public NoteBookProvider(){}

    private final NoteBookDao noteBookDao = new FileNoteBookDao();

    public NoteBookDao getNoteBookDao(){
        return noteBookDao;
    }

    public static NoteBookProvider getInstance(){
        return instance;
    }
}
