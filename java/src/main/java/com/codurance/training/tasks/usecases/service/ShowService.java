package com.codurance.training.tasks.usecases.service;

import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.ProjectListId;
import com.codurance.training.tasks.usecases.port.ProjectListMapper;
import com.codurance.training.tasks.usecases.port.input.projectList.show.ShowInput;
import com.codurance.training.tasks.usecases.port.output.show.ShowOutput;
import com.codurance.training.tasks.usecases.port.input.projectList.show.ShowUseCase;
import com.codurance.training.tasks.usecases.port.output.ProjectListRepository;

public class ShowService implements ShowUseCase {
    private final ProjectListRepository repository;
    public ShowService(ProjectListRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShowOutput execute(ShowInput input) {
        ProjectList projectList = (ProjectList) repository.findById(ProjectListId.of(input.projectListId)).get();
        ShowOutput output = new ShowOutput();
        output.projectListDto = ProjectListMapper.toDto(projectList);
        return output;
    }
}
