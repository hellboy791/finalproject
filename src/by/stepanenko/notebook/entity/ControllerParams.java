package by.stepanenko.notebook.entity;

import java.io.Serializable;
import java.util.Objects;

public class ControllerParams implements Serializable {

    private String command;
    private String date;
    private String content;
    private String id;

    public ControllerParams(){}

    public ControllerParams(String command, String date, String content, String id) {
        this.command = command;
        this.date = date;
        this.content = content;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControllerParams that = (ControllerParams) o;
        return id == that.id && Objects.equals(command, that.command) && Objects.equals(date, that.date) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, date, content, id);
    }

    @Override
    public String toString() {
        return "ControllerParams{" +
                "command=" + command +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", id=" + id +
                '}';
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
