package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.entities.*;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

import java.util.ArrayList;
public class addCommand implements Command {
    public String command;
    private final ProjectList projectList;
    private final CommandOut commandOut;

    public addCommand(String command, ProjectList projectList){
        this.command = command;
        this.projectList = projectList;
        this.commandOut = new CommandOut();
    }
    private void addProject(Project project) {
        projectList.addProject(project.getName(), new ArrayList<Task>());
    }

    private void addTask(Project project, String description) {
        if (project == null) {
            commandOut.addCommandOut("Could not find a project with the name.");
            commandOut.addCommandOut("\n");
            return;
        }
        projectList.getTasks(project.getName()).add(new Task(TaskId.of(projectList.nextId()), description, false));
    }

    @Override
    public CommandOut executeCommand() {
        String[] subcommandRest = command.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(new Project(ProjectName.of(subcommandRest[1]),new ArrayList<>()));
        } else if (subcommand.equals("task")) {
            String[] projectWithTask = subcommandRest[1].split(" ", 2);
            ProjectName projectName = ProjectName.of(projectWithTask[0]);
            String task = projectWithTask[1];
            addTask(projectList.getExistProject(projectName), task);
        }
        return this.commandOut;
    }
}
