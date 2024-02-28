package com.codurance.training.tasks.Command;

import com.codurance.training.tasks.TaskList;

public class CommandCreater {
    public static Command create(String commandLine, TaskList taskList){
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return new showCommand(taskList);
            case "add":
                return new addCommand(commandRest[1], taskList);
            case "check":
                return new checkCommand(commandRest[1], taskList);
            case "uncheck":
                return new uncheckCommand(commandRest[1], taskList);
            case "help":
                return new helpCommand(taskList);
            default:
                return new errorCommand(command, taskList);
        }
    }
}
