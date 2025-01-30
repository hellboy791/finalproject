package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;
import by.stepanenko.notebook.entity.ControllerParams;
import by.stepanenko.notebook.entity.Note;
import by.stepanenko.notebook.service.ServiceProvider;
import by.stepanenko.notebook.service.NotebookService;

import java.util.List;

public class GetAllNotes implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final NotebookService service = serviceProvider.getNotebookService();

    @Override
    public String execute(ControllerParams params) {
        StringBuilder response = new StringBuilder();
        List<Note> notes = service.allNotes();

        if (notes != null){
            for (Note n: notes){
                response.append(n.toString()).append("\n");
            }
        }

        if (response.isEmpty()){
            return "Записей не найдено";
        }
        return response.toString();
    }
}
