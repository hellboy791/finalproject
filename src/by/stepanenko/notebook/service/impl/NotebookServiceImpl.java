package by.stepanenko.notebook.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import by.stepanenko.notebook.dao.NoteBookProvider;
import by.stepanenko.notebook.dao.NoteBookDao;
import by.stepanenko.notebook.entity.Note;
import by.stepanenko.notebook.service.NotebookService;

public class NotebookServiceImpl implements NotebookService {
	private final NoteBookProvider noteBookProvider = NoteBookProvider.getInstance();
	private final NoteBookDao dao = noteBookProvider.getNoteBookDao();

	@Override
	public void createNewFile(){
        dao.createNewFile();
	}
	
	public void add(Note n) {
		dao.addNote(n);
	}
	
	@Override
	public List<Note> find(String text){

		List<Note> result = new ArrayList<>();
		List<Note> myNotes = dao.allNotes();
		
		for(Note n : myNotes) {
			if(isTextInNote(n, text)) {
				result.add(n);
			}
		}
		return result;
	}
	
	private boolean isTextInNote(Note n, String text) {
		return n.getContent().contains(text);
	}

	@Override
	public List<Note> find(LocalDate date){
		List<Note> result = new ArrayList<>();

		List<Note> myNotes = dao.allNotes();
		for (Note note: myNotes){
			if (date.equals(note.getDate())){
				result.add(note);
			}
		}
		return result;
	}

	@Override
	public List<Note> allNotes(){
		return dao.allNotes();
	}

	@Override
	public void save() {
		dao.save();
	}

	@Override
	public void updateNoteByID(String id, String newValue) {
		dao.updateNoteByID(id, newValue);
	}

}
