package com.codurance.training.tasks.adapters.controller;

import com.codurance.training.tasks.adapters.presenter.CommandPresenter;
import com.codurance.training.tasks.adapters.repository.Storage;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.Command.CommandCreater;
import com.codurance.training.tasks.usecases.input.CommandIn;
import com.codurance.training.tasks.usecases.input.InputInterface;

public class CommandController {
    private Command commandExe;

    public CommandPresenter exe(String command, Storage storage){
        InputInterface commandIn = new CommandIn(command);
        this.commandExe = CommandCreater.create(commandIn);
        String Out = this.commandExe.executeCommand(storage).getCommandOut();
        return new CommandPresenter(Out);
    }

    public Command GetCommandExe(){
        return commandExe;
    }


}
