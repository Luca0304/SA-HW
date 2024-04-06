package com.codurance.training.tasks.entities;

import tw.teddysoft.ezddd.core.entity.AggregateRoot;
import tw.teddysoft.ezddd.core.entity.DomainEvent;

import java.util.*;

public class ProjectList extends AggregateRoot<ProjectListId, DomainEvent> {
    private final List<Project> projects;
    private final ProjectListId id;
    private long lastId = 0;

    public ProjectList(ProjectListId id){
        this.id = id;
        this.projects = new ArrayList<>();
    }

    public long nextId() {
        lastId = TaskId.of(lastId +1).value();
        return lastId;
    }
    public List<Project> getProjects() {
        return projects.stream()
                .map(p -> (Project) new ReadOnlyProject(p.getName(), p.getTasks()))
                .toList();
    }

    public void addProject(ProjectName projectName, ArrayList<Task> tasks) {
        Project project = new Project(projectName, tasks);
        this.projects.add(project);

    }

    public List<Task> getTasks(ProjectName projectName) {
        Optional<Project> project =
                projects.stream()
                        .filter(p -> p.getName().equals(projectName))
                        .findFirst();
        if (project.isEmpty()) return null;
        return project.get().getTasks().stream()
                .map(t -> (Task) new ReadOnlyTask(t.getId(), t.getDescription(), t.isDone()))
                .toList();
    }

    @Override
    public ProjectListId getId() {
        return id;
    }

    public boolean containsProject(ProjectName name) {
        return projects.stream()
                .anyMatch(p -> p.getName().equals(name));
    }

    public void addTask(ProjectName name, TaskId taskId, String description, boolean done) {
        Project project_Find =
                projects.stream()
                        .filter(p -> p.getName().equals(name))
                        .findFirst().get();
        project_Find.addTask(taskId, description, done);
    }
}
