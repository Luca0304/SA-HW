package com.codurance.training.tasks.adapters.controller;

import com.codurance.training.tasks.adapters.presenter.CommandPresenter;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.adapters.command.CommandCreater;
import com.codurance.training.tasks.usecases.input.CommandIn;
import com.codurance.training.tasks.usecases.input.InputInterface;

public class CommandController {
    private Command commandExe;

    public CommandPresenter execute(String command){
        InputInterface commandIn = new CommandIn(command);
        this.commandExe = CommandCreater.create(commandIn);
        return new CommandPresenter(this.commandExe.executeCommand());
    }

}
