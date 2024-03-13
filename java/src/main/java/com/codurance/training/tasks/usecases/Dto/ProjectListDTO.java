package com.codurance.training.tasks.usecases.Dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class ProjectListDTO {
    private final Map<ProjectDTO, List<TaskDTO>> tasks = new LinkedHashMap<>();
    private TaskIdDTO lastId = new TaskIdDTO(0);

    public ProjectListDTO() {
    }

    public Map<ProjectDTO, List<TaskDTO>> getTasks() {
        return tasks;
    }

    public TaskIdDTO getNextId() {
        lastId = new TaskIdDTO(lastId.getTaskId() + 1);
        return lastId;
    }
}