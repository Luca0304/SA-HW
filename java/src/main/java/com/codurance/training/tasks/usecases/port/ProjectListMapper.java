package com.codurance.training.tasks.usecases.port;

import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.usecases.port.input.projectList.show.ProjectListDto;

public class ProjectListMapper {
    public static ProjectListDto toDto(ProjectList projectList) {
        ProjectListDto projectListDto = new ProjectListDto();
        projectListDto.id = projectList.getId().value();
        projectListDto.projectDots =
                ProjectMapper.toDto(projectList.getProjects());

        return projectListDto;
    }
}
