package com.codurance.training.tasks.entities;

import java.util.*;

public class ProjectList {
    private final List<Project> projects;

    private long lastId = 0;

    public ProjectList(){
        this.projects = new ArrayList<>();
    }

    public long nextId() {
        lastId = TaskId.of(lastId +1).value();
        return lastId;
    }
    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public void addProject(ProjectName projectName, ArrayList<Task> tasks) {
        Project project = new Project(projectName, tasks);
        this.projects.add(project);

    }

    public List<Task> getTasks(ProjectName projectName) {
        return projects.stream()
                .filter(project -> project.getName().equals(projectName))
                .findFirst()
                .map(Project::getTasks)
                .orElse(null);
    }

    public Project getExistProject(ProjectName projectName) {
        return projects.stream()
                .filter(getProject -> getProject.getName().equals(projectName))
                .findFirst()
                .orElse(null);
    }


}
