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

public class checkCommand implements Command {
    public String id;
    private final ProjectListDTO projectListDTO;

    private CommandOut commandOut;
    public checkCommand(String id, ProjectListDTO projectListDTO) {
        this.id = id;
        this.projectListDTO = projectListDTO;
        this.commandOut = new CommandOut();
    }
    private void setDone(String idString) {
        for (Map.Entry<ProjectDTO, List<TaskDTO>> project : projectListDTO.getTasks().entrySet()) {
            for (TaskDTO task : project.getValue()) {
                if (String.valueOf(task.getId().getTaskId()).equals(idString)) {
                    task.setDone(true);
                    return;
                }
            }
        }
        commandOut.addCommandOut(String.format("Could not find a task with an ID of %s.", idString));
        commandOut.addCommandOut("\n");
    }
    private void check(String idString) {
        setDone(idString);
    }

    @Override
    public void executeCommandMethod() {
        check(this.id);
    }

    @Override
    public CommandOut executeCommand(Storage storage) {
        check(this.id);
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
