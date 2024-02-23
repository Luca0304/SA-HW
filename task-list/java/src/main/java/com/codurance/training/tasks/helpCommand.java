package com.codurance.training.tasks;

public class helpCommand implements Command {

    @Override
    public void executeCommand(TaskList taskList) {
        taskList.help();
    }
}
