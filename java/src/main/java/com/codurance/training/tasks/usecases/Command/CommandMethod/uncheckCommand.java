package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.adapters.repository.Storage;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.Dto.Mapper.ProjectListMapper;
import com.codurance.training.tasks.usecases.Dto.ProjectDTO;
import com.codurance.training.tasks.usecases.Dto.ProjectListDTO;
import com.codurance.training.tasks.usecases.Dto.TaskDTO;
import com.codurance.training.tasks.usecases.output.CommandOut;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class uncheckCommand implements Command {
    public String id;
    private final ProjectListDTO projectListDTO;
    private CommandOut commandOut;
    public uncheckCommand(String id, ProjectListDTO projectListDTO) {
        this.id = id;
        this.projectListDTO = projectListDTO;
        this.commandOut = new CommandOut();
    }
    private void setUnDone(String idString) {
        for (Map.Entry<ProjectDTO, List<TaskDTO>> project : projectListDTO.getTasks().entrySet()) {
            for (TaskDTO task : project.getValue()) {
                if (Objects.equals(task.getId(), idString)) {
                    task.setDone(false);
                    return;
                }
            }
        }
        commandOut.addCommandOut(String.format("Could not find a task with an ID of %s.", idString));
        commandOut.addCommandOut("\n");
    }
    public void uncheck(String idString) {
        setUnDone(idString);
    }

    @Override
    public void executeCommandMethod() {
        uncheck(this.id);
    }

    @Override
    public CommandOut executeCommand(Storage storage) {
        uncheck(this.id);
        storage.save(ProjectListMapper.mapToProjectList(projectListDTO));
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
