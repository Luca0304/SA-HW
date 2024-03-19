package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

public class helpCommand implements Command {
    private final CommandOut commandOut;
    public helpCommand() {
        this.commandOut = new CommandOut();
    }

    private void help() {
        commandOut.addCommandOut("Commands:\n");
        commandOut.addCommandOut("  show\n");
        commandOut.addCommandOut("  add project <project name>\n");
        commandOut.addCommandOut("  add task <project name> <task description>\n");
        commandOut.addCommandOut("  check <task ID>\n");
        commandOut.addCommandOut("  uncheck <task ID>\n");
    }

    @Override
    public void executeCommandMethod() {
        help();
    }

    @Override
    public CommandOut executeCommand() {
        help();
        return this.commandOut;
    }
}
