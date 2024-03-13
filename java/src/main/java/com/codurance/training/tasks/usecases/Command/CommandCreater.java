package com.codurance.training.tasks.usecases.Command;

import com.codurance.training.tasks.usecases.Dto.ProjectListDTO;
import com.codurance.training.tasks.usecases.input.InputInterface;
import com.codurance.training.tasks.usecases.Command.CommandMethod.showCommand;
import com.codurance.training.tasks.usecases.Command.CommandMethod.addCommand;
import com.codurance.training.tasks.usecases.Command.CommandMethod.checkCommand;
import com.codurance.training.tasks.usecases.Command.CommandMethod.uncheckCommand;
import com.codurance.training.tasks.usecases.Command.CommandMethod.helpCommand;
import com.codurance.training.tasks.usecases.Command.CommandMethod.errorCommand;

public class CommandCreater{
    private static final ProjectListDTO projectListDTO = new ProjectListDTO();
    public static Command create(InputInterface commandIn){
        String[] commandRest = commandIn.getCommandIn().split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return new showCommand(projectListDTO);
            case "add":
                return new addCommand(commandRest[1], projectListDTO);
            case "check":
                return new checkCommand(commandRest[1], projectListDTO);
            case "uncheck":
                return new uncheckCommand(commandRest[1], projectListDTO);
            case "help":
                return new helpCommand();
            default:
                return new errorCommand(command);
        }
    }
}
