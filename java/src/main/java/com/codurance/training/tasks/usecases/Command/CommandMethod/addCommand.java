package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.entities.Project;
import com.codurance.training.tasks.entities.Task;
import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class addCommand implements Command {
    public String activity;
    private final ProjectList projectList;
    private CommandOut commandOut;

    public addCommand(String activity, ProjectList projectList){
        this.activity = activity;
        this.projectList = projectList;
        this.commandOut = new CommandOut();
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(new Project(subcommandRest[1]));
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            Set<Project> projects = projectList.getTasks().keySet();
            Project project = projects.stream()
                    .filter(getProject -> Objects.equals(getProject.getName(), projectTask[0]))
                    .findFirst()
                    .orElse(null);
            addTask(project, projectTask[1]);
        }
    }

    private void addProject(Project project) {
        projectList.getTasks().put(project, new ArrayList<Task>());
    }

    private void addTask(Project project, String description) {
        if (project == null) {
            commandOut.addCommandOut("Could not find a project with the name.");
            commandOut.addCommandOut("\n");
            return;
        }
        projectList.getTasks().get(project).add(new Task(projectList.nextId(), description, false));
    }


    @Override
    public void executeCommandMethod() {
        add(this.activity);
    }

    @Override
    public CommandOut executeCommand() {
        add(this.activity);
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
