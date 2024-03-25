package com.codurance.training.tasks.adapters.presenter;

import com.codurance.training.tasks.usecases.output.OutputInterface;
public class CommandPresenter {
    public OutputInterface commandOut;
    public CommandPresenter(OutputInterface commandOut){
        this.commandOut = commandOut;
    }
    public String exeOut(){
        return commandOut.getCommandOut();
    }
}
