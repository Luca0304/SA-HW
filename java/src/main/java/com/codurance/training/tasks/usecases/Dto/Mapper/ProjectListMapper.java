package com.codurance.training.tasks.usecases.Dto.Mapper;

import com.codurance.training.tasks.entities.Project;
import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.Task;
import com.codurance.training.tasks.entities.TaskId;
import com.codurance.training.tasks.usecases.Dto.ProjectDTO;
import com.codurance.training.tasks.usecases.Dto.ProjectListDTO;
import com.codurance.training.tasks.usecases.Dto.TaskDTO;
import com.codurance.training.tasks.usecases.Dto.TaskIdDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProjectListMapper {

    public static ProjectList mapToProjectList(ProjectListDTO projectListDTO) {
        ProjectList projectList = new ProjectList();
        for (Map.Entry<ProjectDTO, List<TaskDTO>> entry : projectListDTO.getTasks().entrySet()) {
            ProjectDTO projectDTO = entry.getKey();
            Project project = new Project(projectDTO.getName());
            List<Task> tasks = new ArrayList<>();
            for (TaskDTO taskDTO : entry.getValue()) {
                TaskIdDTO taskIdDTO = taskDTO.getId();
                TaskId taskId = new TaskId(taskIdDTO.getTaskId());
                Task task = new Task(taskId, taskDTO.getDescription(), taskDTO.isDone());
                tasks.add(task);
            }
            project.getTasks().addAll(tasks);
            projectList.getTasks().put(project, tasks);
        }
        return projectList;
    }

}