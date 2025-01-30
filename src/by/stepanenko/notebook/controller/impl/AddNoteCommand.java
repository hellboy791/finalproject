package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;
import by.stepanenko.notebook.entity.ControllerParams;
import by.stepanenko.notebook.entity.Note;
import by.stepanenko.notebook.service.ServiceProvider;
import by.stepanenko.notebook.service.NotebookService;
import by.stepanenko.notebook.utils.SymbolsValidator;

public class AddNoteCommand implements Command {
	
	private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
	private final NotebookService service = serviceProvider.getNotebookService();

	@Override
	public String execute(ControllerParams params) {

		Note newNote;
		SymbolsValidator symbolsValidator = new SymbolsValidator();

		if (symbolsValidator.match(params.getContent())){
			return "Cannot create note: unsupported symbol";
		}
		newNote = new Note(params.getContent());
		service.add(newNote);

		return "Запись добавлена.";
	}

}
