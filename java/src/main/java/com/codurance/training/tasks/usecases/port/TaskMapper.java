package com.codurance.training.tasks.usecases.port;

import com.codurance.training.tasks.entities.Task;
import com.codurance.training.tasks.usecases.port.input.projectList.show.TaskDto;

import java.util.List;

public class TaskMapper {

    public static TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.id = task.getId().toString();
        taskDto.description = task.getDescription();
        taskDto.done = task.isDone();
        return taskDto;
    }

    public static List<TaskDto> toDto(List<Task> tasks) {
        return tasks.stream().map(TaskMapper::toDto).toList();
    }

}
