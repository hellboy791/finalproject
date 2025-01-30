package by.stepanenko.notebook.dao.impl;

import by.stepanenko.notebook.entity.Note;
import by.stepanenko.notebook.utils.IDGenerator;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockSource {

    private static MockSource instance;
    public MockSource(){}

    public static MockSource getInstance() {
        if (instance == null){
            instance = new MockSource();
        }
        instance.getAllNotes(); //получаем список всех записей при инициализации ??????????
        return instance;
    }

    private static List<Note> notes;
    private final String filePath = System.getProperty("user.home") + "/NoteBook.txt";
    private final String columnSeparator = ";"; //разделитель между колонками

    public void createNewFileNote(){
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void save() {
        FileWriter writer;
        File file = new File(filePath);
        String sepForNotes = "\n";

        //если файла нет, то создаем чтоб не потерять при выходе все записи, что добавили
        if (!file.exists()){
            createNewFileNote();
        }

        if (file.exists()){
            try {
                writer = new FileWriter(filePath, false);
                for (Note note: notes){
                    writer.write(note.getDate().toString() + columnSeparator + note.getContent() + sepForNotes);
                }
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Note> getAllNotes(){
        String[] ts;
        File file = new File(filePath);
        if (file.exists()){
            if (notes == null){
                notes = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String strCurrentLine;
                    while ((strCurrentLine = reader.readLine()) != null){
                        ts = strCurrentLine.split(columnSeparator);
                        notes.add(new Note(String.valueOf(IDGenerator.getNextId()), LocalDate.parse(ts[0]), ts[1]));
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return notes;
    }

    public Note getNoteByID(String id){
        if (notes != null){
            for (Note n: notes){
                if (n.getId().equals(id)){
                    return n;
                }
            }
        }
        return null;
    }

    public void updateNoteByID(String id, String newValue){

        Note note = getNoteByID(id);
        if (note != null){
            note.setContent(newValue);
        } else {
            throw new RuntimeException("Cannot find note with id " + id);
        }
    }

}
