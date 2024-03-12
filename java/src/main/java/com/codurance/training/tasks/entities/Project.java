package com.codurance.training.tasks.entities;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private final String name;
    private final List<Task> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
