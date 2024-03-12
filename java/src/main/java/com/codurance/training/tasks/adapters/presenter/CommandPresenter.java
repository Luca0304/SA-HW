package com.codurance.training.tasks.adapters.presenter;

public class CommandPresenter {
    public String commandExe;
    public CommandPresenter(){
    }

    public CommandPresenter(String commandExe){
        this.commandExe = commandExe;
    }

    public String exeOutput(){
        return commandExe;
    }
}
