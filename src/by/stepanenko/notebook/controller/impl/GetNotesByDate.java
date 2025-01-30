package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;
import by.stepanenko.notebook.entity.ControllerParams;
import by.stepanenko.notebook.entity.Note;
import by.stepanenko.notebook.service.ServiceProvider;
import by.stepanenko.notebook.service.NotebookService;
import by.stepanenko.notebook.utils.DateFormatValidator;
import java.time.LocalDate;
import java.util.List;

public class GetNotesByDate implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final NotebookService service = serviceProvider.getNotebookService();

    @Override
    public String execute(ControllerParams params) {

        StringBuilder response = new StringBuilder();
        List<Note> notes;
        DateFormatValidator dateFormatValidator = new DateFormatValidator();

        System.out.println(!dateFormatValidator.match(params.getDate()));

        if (!dateFormatValidator.match(params.getDate())){
            return "Check Date format";
        }

        notes = service.find(LocalDate.parse(params.getDate()));
        if (notes != null){
            for (Note n: notes){
                response.append(n.toString()).append("\n");
            }
        }

        if (response.toString().isEmpty()){
            return "Записей не найдено";
        }
        return response.toString();
    }
}
