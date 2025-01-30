package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;
import by.stepanenko.notebook.entity.ControllerParams;
import by.stepanenko.notebook.service.NotebookService;
import by.stepanenko.notebook.service.ServiceProvider;

public class UpdateNoteByID implements Command {

    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final NotebookService service = serviceProvider.getNotebookService();

    @Override
    public String execute(ControllerParams params) {

        service.updateNoteByID(params.getId(), params.getContent());
        return "Запись обновлена";
    }
}