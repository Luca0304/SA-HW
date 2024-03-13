package com.codurance.training.tasks.usecases.Dto;

import java.util.ArrayList;
import java.util.List;
public class ProjectDTO {
    private final String name;
    private final List<TaskDTO> tasks;

    public ProjectDTO(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    // Optionally, you can provide methods to add tasks to the project
    public void addTask(TaskDTO task) {
        tasks.add(task);
    }

}