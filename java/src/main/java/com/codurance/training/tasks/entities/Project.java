package com.codurance.training.tasks.entities;

import java.util.Collections;
import java.util.List;

public class Project {
    private final ProjectName name;
    private final List<Task> tasks;

    public Project(ProjectName name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }
    public ProjectName getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
