package by.stepanenko.notebook.entity;


import by.stepanenko.notebook.utils.IDGenerator;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Note implements Serializable {

    private String id;
    private LocalDate d;
    private String content;

    public Note() {}

    public Note(String id, LocalDate d, String content ) {
        this.id = id;
        this.d = d;
        this.content = content;
    }

    public Note(String content){
        this.id = String.valueOf(IDGenerator.getNextId());
        this.d = LocalDate.now();
        this.content = content;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setDate(LocalDate d){
        this.d = d;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getId(){
        return this.id;
    }

    public String getContent(){
        return this.content;
    }

    public LocalDate getDate(){
        return this.d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id && Objects.equals(d, note.d) && Objects.equals(content, note.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, d, content);
    }

    @Override
    public String toString() {
        return  "id = " + id +
                ", date = " + d.toString() +
                ", content = '" + content + "'";
    }
}
