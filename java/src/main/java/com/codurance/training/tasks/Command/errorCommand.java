package com.codurance.training.tasks.Command;

import com.codurance.training.tasks.TaskList;

public class errorCommand implements Command {
    public String command;
    private final TaskList taskList;
    public errorCommand(String command, TaskList taskList) {
        this.command = command;
        this.taskList = taskList;
    }
    private void error(String command) {
        taskList.out.printf("I don't know what the command \"%s\" is.", command);
        taskList.out.println();
    }

    @Override
    public void executeCommand() {
        error(this.command);
    }
}
