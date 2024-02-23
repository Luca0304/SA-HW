package com.codurance.training.tasks;

public class showCommand implements Command {

    @Override
    public void executeCommand(TaskList taskList) {
        taskList.show();
    }
}
