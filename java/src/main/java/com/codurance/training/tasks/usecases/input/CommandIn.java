package com.codurance.training.tasks.usecases.input;

public class CommandIn implements InputInterface {
    private final String commandIn;
    public CommandIn(String commandIn) {
        this.commandIn = commandIn;
    }

    public String getCommandIn(){
        return this.commandIn;
    }
}
