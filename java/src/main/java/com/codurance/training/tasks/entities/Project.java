package com.codurance.training.tasks.entities;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private final ProjectName name;
    private final List<Task> tasks;

    public Project(ProjectName name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name.toString();
    }
    public List<Task> getTasks() {
        return tasks;
    }
}
