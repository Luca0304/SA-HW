package com.codurance.training.tasks.entities;

import java.util.*;

public class ProjectList {
    private final Map<Project, List<Task>> tasks = new LinkedHashMap<>();

    private long lastId = 0;

    public ProjectList(){
    }
    public Map<Project, List<Task>> getTasks(){
        return this.tasks;
    }
    public long nextId() {
        lastId = TaskId.of(lastId +1).value();
        return lastId;
    }

    public Set<Map.Entry<Project, List<Task>>> entrySet() {
        return tasks.entrySet();
    }

    public void put(Project project, ArrayList<Task> tasks) {
        this.tasks.put(project, tasks);
    }

    public List<Task> get(Project project) {
        return this.tasks.get(project);
    }



}
