package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.entities.*;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class addCommand implements Command {
    public String activity;
    private final ProjectList projectList;
    private final CommandOut commandOut;

    public addCommand(String activity, ProjectList projectList){
        this.activity = activity;
        this.projectList = projectList;
        this.commandOut = new CommandOut();
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(new Project(ProjectName.of(subcommandRest[1])));
        } else if (subcommand.equals("task")) {
            //projectWithTask[0]=projectName , projectWithTask[1]=task
            String[] projectWithTask = subcommandRest[1].split(" ", 2);
            Project project = getExistProject(projectWithTask[0]);
            addTask(project, projectWithTask[1]);
        }
    }

    private Project getExistProject(String projectName) {
        Set<Project> projects = projectList.keySet();
        return projects.stream()
                .filter(getProject -> getProject.getName().equals(projectName))
                .findFirst()
                .orElse(null);
    }

    private void addProject(Project project) {
        projectList.put(project, new ArrayList<Task>());
    }

    private void addTask(Project project, String description) {
        if (project == null) {
            commandOut.addCommandOut("Could not find a project with the name.");
            commandOut.addCommandOut("\n");
            return;
        }
        projectList.get(project).add(new Task(TaskId.of(projectList.nextId()), description, false));
    }

    @Override
    public CommandOut executeCommand() {
        add(this.activity);
        return this.commandOut;
    }
}
