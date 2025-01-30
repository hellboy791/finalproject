package by.stepanenko.notebook.controller;

import by.stepanenko.notebook.entity.ControllerParams;

public interface Command {
	String execute(ControllerParams params);
}
