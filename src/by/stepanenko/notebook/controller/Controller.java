package by.stepanenko.notebook.controller;

import by.stepanenko.notebook.entity.ControllerParams;

public class Controller {

	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(ControllerParams params) {

		Command executionCommand;
		String response;

		executionCommand = provider.getCommand(params.getCommand().toUpperCase());//ADD
		response = executionCommand.execute(params);
		
		return response;

	}

}