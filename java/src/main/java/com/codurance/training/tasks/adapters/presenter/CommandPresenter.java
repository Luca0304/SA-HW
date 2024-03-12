package com.codurance.training.tasks.adapters.presenter;

import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.OutputInterface;
public class CommandPresenter {
    public OutputInterface commandOut;
    public CommandPresenter(){
    }
    public CommandPresenter(OutputInterface commandOut){
        this.commandOut = commandOut;
    }
    public CommandPresenter(Command commandExe){
        commandOut = commandExe.getCommandOut();
    }
    public String exeOut(){
        return commandOut.getCommandOut();
    }
}
