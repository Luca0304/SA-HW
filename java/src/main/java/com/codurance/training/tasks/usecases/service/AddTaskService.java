package com.codurance.training.tasks.usecases.service;

import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.ProjectListId;
import com.codurance.training.tasks.entities.ProjectName;
import com.codurance.training.tasks.entities.TaskId;
import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskDto;
import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskInput;
import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskUseCase;
import com.codurance.training.tasks.usecases.port.output.ProjectListRepository;
import com.codurance.training.tasks.usecases.port.output.add.AddTaskOutput;
import com.codurance.training.tasks.usecases.port.output.add.AddTaskPresenter;
import tw.teddysoft.ezddd.core.usecase.ExitCode;

import java.util.Optional;

public class AddTaskService implements AddTaskUseCase {
    private final ProjectListRepository repository;
    private final AddTaskPresenter presenter;

    public AddTaskService(ProjectListRepository repository, AddTaskPresenter presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }
    @Override
    public AddTaskOutput execute(AddTaskInput taskInput) {
        Optional<ProjectList> projectList = repository.findById(ProjectListId.of(taskInput.projectListId));
        AddTaskOutput output = AddTaskOutput.create();
        if(!projectList.get().containsProject(ProjectName.of(taskInput.projectName))){
            AddTaskDto addTaskDto = new AddTaskDto();
            addTaskDto.commandLine = "Could not find a project with the name ";
            addTaskDto.projectName = taskInput.projectName;
            output.addTaskDto = addTaskDto;
            presenter.present(addTaskDto);
            return output.setExitCode(ExitCode.SUCCESS).setMessage("");
        }
        projectList.get().addTask(ProjectName.of(taskInput.projectName), TaskId.of(projectList.get().nextId()), taskInput.description, false);
        repository.save(projectList.get());

        return output.setExitCode(ExitCode.SUCCESS).setMessage("");
    }
}
