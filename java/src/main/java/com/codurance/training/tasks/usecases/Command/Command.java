package com.codurance.training.tasks.usecases.Command;

import com.codurance.training.tasks.usecases.output.CommandOut;

public interface Command {
    void executeCommandMethod();
    CommandOut executeCommand();
}
