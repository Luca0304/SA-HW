package com.codurance.training.tasks;

public class errorCommand implements Command {
    public String command;
    public errorCommand(String command) {
        this.command = command;
    }

    @Override
    public void executeCommand(TaskList taskList) {
        taskList.error(this.command);
    }
}
