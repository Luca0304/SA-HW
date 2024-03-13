package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.adapters.repository.Storage;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.Dto.ProjectDTO;
import com.codurance.training.tasks.usecases.Dto.ProjectListDTO;
import com.codurance.training.tasks.usecases.Dto.TaskDTO;
import com.codurance.training.tasks.usecases.output.CommandOut;

import java.util.List;
import java.util.Map;

public class showCommand implements Command {
    private final ProjectListDTO projectListDTO;
    private final CommandOut commandOut;
    public showCommand(ProjectListDTO projectListDTO) {
        this.projectListDTO = projectListDTO;
        this.commandOut = new CommandOut();
    }
    private void show() {
        for (Map.Entry<ProjectDTO, List<TaskDTO>> project : projectListDTO.getTasks().entrySet()) {
            commandOut.addCommandOut(String.valueOf(project.getKey().getName()));
            commandOut.addCommandOut("\r\n");
            for (TaskDTO task : project.getValue()) {
                commandOut.addCommandOut(String.format("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId().getTaskId(), task.getDescription()));
            }
            commandOut.addCommandOut("\r\n");
        }
    }

    @Override
    public void executeCommandMethod() {
        show();
    }

    @Override
    public CommandOut executeCommand(Storage storage) {
        show();
        return this.commandOut;
    }

    @Override
    public String exeOut() {
        return commandOut.getCommandOut();
    }

    @Override
    public CommandOut getCommandOut() {
        return commandOut;
    }
}
