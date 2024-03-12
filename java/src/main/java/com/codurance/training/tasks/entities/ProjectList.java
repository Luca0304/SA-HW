package com.codurance.training.tasks.entities;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProjectList {
    private final Map<Project, List<Task>> tasks = new LinkedHashMap<>();

    private TaskId lastId = new TaskId(0);

    public ProjectList(){
    }
    public Map<Project, List<Task>> getTasks(){
        return this.tasks;
    }
    public TaskId nextId() {
        lastId = new TaskId(lastId.getTaskId() + 1);
        return lastId;
    }


}
