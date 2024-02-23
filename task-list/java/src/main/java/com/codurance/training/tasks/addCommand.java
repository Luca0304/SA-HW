package com.codurance.training.tasks;

public class addCommand implements Command {
    public String activity;
    public addCommand(String activity){
        this.activity = activity;
    }
    @Override
    public void executeCommand(TaskList taskList) {
        taskList.add(this.activity);
    }
}
