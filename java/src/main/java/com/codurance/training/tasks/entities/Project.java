package com.codurance.training.tasks.entities;

import tw.teddysoft.ezddd.core.entity.Entity;

import java.util.List;

public class Project implements Entity<ProjectName>{
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

    @Override
    public ProjectName getId() {
        return name;
    }

    public void addTask(TaskId taskId, String description, boolean done){
        this.tasks.add(new Task(taskId, description, done));
    }
}
