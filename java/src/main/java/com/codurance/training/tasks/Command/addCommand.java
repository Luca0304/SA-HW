package com.codurance.training.tasks.Command;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.util.ArrayList;

public class addCommand implements Command {
    public String activity;
    private final TaskList taskList;
    public addCommand(String activity, TaskList taskList){
        this.activity = activity;
        this.taskList = taskList;
    }

    private void add(String commandLine) {
        String[] subcommandList = commandLine.split(" ", 2);
        addMethod(subcommandList);
    }

    private void addMethod(String[] subcommandList) {
        if (subcommandList[0].equals("project")) {
            addProject(subcommandList[1]);
        } else if (subcommandList[0].equals("task")) {
            String[] projectTask = subcommandList[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addProject(String name) {
        taskList.tasks.put(name, new ArrayList<Task>());
    }

    private boolean checkProjectNonExist(String project) {
        if (taskList.tasks.get(project) == null) {
            taskList.out.printf("Could not find a project with the name \"%s\".", project);
            taskList.out.println();
            return true;
        }
        return false;
    }

    private void addTask(String project, String description) {
        if (checkProjectNonExist(project)) return;
        taskList.tasks.get(project).add(new Task(++taskList.lastId, description, false));
    }

    @Override
    public void executeCommand() {
        add(this.activity);
    }
}
