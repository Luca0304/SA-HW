package com.codurance.training.tasks.usecases.Dto;

public final class TaskDTO {
    private final TaskIdDTO id;
    private final String description;
    private boolean done;

    public TaskDTO(TaskIdDTO id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public TaskIdDTO getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}