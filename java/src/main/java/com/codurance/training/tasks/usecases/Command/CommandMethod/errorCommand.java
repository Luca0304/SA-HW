package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

public class errorCommand implements Command {
    public String command;
    private final CommandOut commandOut;
    public errorCommand(String command) {
        this.command = command;
        this.commandOut = new CommandOut();
    }
    @Override
    public CommandOut executeCommand() {
        commandOut.addCommandOut(String.format("I don't know what the command \"%s\" is.", this.command)+"\n");
        return this.commandOut;
    }
}
