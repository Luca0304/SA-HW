package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.adapters.repository.Storage;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.Dto.Mapper.ProjectListMapper;
import com.codurance.training.tasks.usecases.Dto.ProjectDTO;
import com.codurance.training.tasks.usecases.Dto.ProjectListDTO;
import com.codurance.training.tasks.usecases.Dto.TaskDTO;
import com.codurance.training.tasks.usecases.output.CommandOut;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class addCommand implements Command {
    public String activity;
    private final ProjectListDTO projectListDTO;
    private CommandOut commandOut;

    public addCommand(String activity, ProjectListDTO projectListDTO){
        this.activity = activity;
        this.projectListDTO = projectListDTO;
        this.commandOut = new CommandOut();
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(new ProjectDTO(subcommandRest[1]));
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            Set<ProjectDTO> projects = projectListDTO.getTasks().keySet();
            ProjectDTO project = projects.stream()
                    .filter(getProject -> Objects.equals(getProject.getName(), projectTask[0]))
                    .findFirst()
                    .orElse(null);
            addTask(project, projectTask[1]);
        }
    }

    private void addProject(ProjectDTO projectDTO) {
        projectListDTO.getTasks().put(projectDTO, new ArrayList<TaskDTO>());
    }

    private void addTask(ProjectDTO project, String description) {
        if (project == null) {
            commandOut.addCommandOut("Could not find a project with the name.");
            commandOut.addCommandOut("\n");
            return;
        }
        projectListDTO.getTasks().get(project).add(new TaskDTO(projectListDTO.getNextId(), description, false));
    }


    @Override
    public void executeCommandMethod() {
        add(this.activity);
    }

    @Override
    public CommandOut executeCommand(Storage storage) {
        add(this.activity);
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
