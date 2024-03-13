package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.adapters.repository.Storage;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

public class errorCommand implements Command {
    public String command;
    private CommandOut commandOut;
    public errorCommand(String command) {
        this.command = command;
        this.commandOut = new CommandOut();
    }
    private void error(String command) {
        commandOut.addCommandOut(String.format("I don't know what the command \"%s\" is.", command));
        commandOut.addCommandOut("\n");
    }

    @Override
    public void executeCommandMethod() {
        error(this.command);
    }

    @Override
    public CommandOut executeCommand(Storage storage) {
        error(this.command);
        return this.commandOut;
    }

    @Override
    public String exeOut() {
        return commandOut.getCommandOut();
    }

    @Override
    public CommandOut getCommandOut() {
        return commandOut;
    }
}
