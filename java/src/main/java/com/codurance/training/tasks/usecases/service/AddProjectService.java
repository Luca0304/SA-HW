package com.codurance.training.tasks.usecases.service;

import com.codurance.training.tasks.entities.ProjectName;
import com.codurance.training.tasks.entities.Task;
import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.ProjectListId;
import com.codurance.training.tasks.usecases.port.output.ProjectListRepository;
import com.codurance.training.tasks.usecases.port.input.project.add.AddProjectInput;
import com.codurance.training.tasks.usecases.port.input.project.add.AddProjectUseCase;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

import java.util.ArrayList;
import java.util.Optional;

public class AddProjectService implements AddProjectUseCase {
    private final ProjectListRepository repository;
    public AddProjectService(ProjectListRepository repository) {
        this.repository = repository;
    }

    @Override
    public CqrsOutput execute(AddProjectInput projectInput) {

        Optional<ProjectList> projectList = repository.findById(ProjectListId.of(projectInput.projectListId));
        projectList.get().addProject(ProjectName.of(projectInput.projectName), new ArrayList<Task>());
        repository.save(projectList.get());

        return CqrsOutput.create().succeed().setId(projectInput.projectName);
    }

}
