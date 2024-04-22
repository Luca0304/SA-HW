package com.codurance.training.tasks.usecases.port.input.projectList.show;

import java.util.ArrayList;
import java.util.List;

public class ProjectListDto {
    public String id;
    public List<ProjectDto> projectDots;
    public ProjectListDto() {
        this.projectDots = new ArrayList<>();
    }
}
