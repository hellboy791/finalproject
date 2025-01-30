package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;
import by.stepanenko.notebook.entity.ControllerParams;

public class Exit implements Command {

    @Override
    public String execute(ControllerParams params) {
        return "Работа с блокнотом завершена";
    }

}