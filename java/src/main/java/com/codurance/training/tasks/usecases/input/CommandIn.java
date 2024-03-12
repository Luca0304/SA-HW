package com.codurance.training.tasks.usecases.input;

public class CommandIn implements InputInterface {
    private String commandIn;
    public CommandIn(String commandIn) {
        this.commandIn = commandIn;
    }

    public void addCommandIn(String commandIn){
        this.commandIn = commandIn;
    }

    public String getCommandIn(){
        return this.commandIn;
    }
}
