package by.stepanenko.notebook.controller;

import java.util.HashMap;
import java.util.Map;
import by.stepanenko.notebook.controller.impl.*;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.CREATENEWFILE, new CreateFileCommand());
		repository.put(CommandName.ADD, new AddNoteCommand());
		repository.put(CommandName.GETALLNOTES, new GetAllNotes());
		repository.put(CommandName.GETNOTEBYDATE, new GetNotesByDate());
		repository.put(CommandName.GETNOTESBYCONTENT, new GetNotesByContent());
		repository.put(CommandName.SAVE, new SaveChanges());
		repository.put(CommandName.UPDATENOTEBYID, new UpdateNoteByID());
		repository.put(CommandName.EXIT, new Exit());
		//...
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
	}
	
	Command getCommand(String name){//ADD
		CommandName commandName;
		Command command;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e){
			//write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}				
		return command;
	}

}
