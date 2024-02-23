package com.codurance.training.tasks;

public class CommandCreater {
    static Command create(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return new showCommand();
            case "add":
                return new addCommand(commandRest[1]);
            case "check":
                return new checkCommand(commandRest[1]);
            case "uncheck":
                return new uncheckCommand(commandRest[1]);
            case "help":
                return new helpCommand();
            default:
                return new errorCommand(command);
        }
    }
}
