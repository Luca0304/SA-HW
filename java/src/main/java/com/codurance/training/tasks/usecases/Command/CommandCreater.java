package com.codurance.training.tasks.usecases.Command;

import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.ProjectListId;
import com.codurance.training.tasks.usecases.Command.CommandMethod.*;
import com.codurance.training.tasks.usecases.input.InputInterface;

public class CommandCreater{
    private static final ProjectListId DEFAULT_PROJECT_LIST_ID = ProjectListId.of("001");
    private static final ProjectList projectList = new ProjectList(DEFAULT_PROJECT_LIST_ID);
    public static Command create(InputInterface commandIn){
        String[] commandRest = commandIn.getCommandIn().split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return new showCommand(projectList);
            case "add":
                return new addCommand(commandRest[1], projectList);
            case "check":
                return new checkCommand(commandRest[1], projectList);
            case "uncheck":
                return new uncheckCommand(commandRest[1], projectList);
            case "help":
                return new helpCommand();
            default:
                return new errorCommand(command);
        }
    }
}
