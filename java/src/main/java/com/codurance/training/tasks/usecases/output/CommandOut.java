package com.codurance.training.tasks.usecases.output;

import java.util.ArrayList;
import java.util.List;

public class CommandOut implements OutputInterface{
    private final List<String> commandOut;
    public CommandOut() {
        this.commandOut = new ArrayList<>();
    }

    public void addCommandOut(String commandOut){
        this.commandOut.add(commandOut);
    }

    public String getCommandOut(){
        StringBuilder merged = new StringBuilder();
        for (String line : commandOut) {
            merged.append(line);
        }
        return merged.toString();
    }
}
