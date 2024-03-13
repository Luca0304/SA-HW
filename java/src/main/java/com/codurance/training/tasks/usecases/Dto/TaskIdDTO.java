package com.codurance.training.tasks.usecases.Dto;


public class TaskIdDTO {
    private long taskId;

    public TaskIdDTO(long taskId) {
        this.taskId = taskId;
    }

    public long getTaskId() {
        return taskId;
    }
}