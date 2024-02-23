package com.codurance.training.tasks;

public class checkCommand implements Command {
    public String id;
    public checkCommand(String id) {
        this.id = id;
    }
    @Override
    public void executeCommand(TaskList taskList) {
        taskList.check(this.id);
    }
}
