package com.codurance.training.tasks;

public class uncheckCommand implements Command {
    public String id;
    public uncheckCommand(String id) {
        this.id = id;
    }
    @Override
    public void executeCommand(TaskList taskList) {
        taskList.uncheck(this.id);
    }

}
