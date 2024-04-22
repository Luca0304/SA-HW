package com.codurance.training.tasks.usecases.service;

import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.ProjectListId;
import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneDto;
import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneInput;
import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneUseCase;
import com.codurance.training.tasks.usecases.port.output.ProjectListRepository;
import com.codurance.training.tasks.usecases.port.output.setdone.SetDoneOutput;
import com.codurance.training.tasks.usecases.port.output.setdone.SetDonePresenter;
import tw.teddysoft.ezddd.core.usecase.ExitCode;

import java.util.Optional;

public class SetDoneService implements SetDoneUseCase {
    private final SetDonePresenter presenter;

    private final ProjectListRepository repository;

    public SetDoneService(ProjectListRepository repository, SetDonePresenter presenter){
        this.repository = repository;
        this.presenter = presenter;
    }
    @Override
    public SetDoneOutput execute(SetDoneInput input) {
        Optional<ProjectList> projectList = repository.findById(ProjectListId.of(input.projectListId));
        SetDoneOutput output = new SetDoneOutput();
        boolean verifySetDone = projectList.get().setDone(input.taskId, input.done);
        if(verifySetDone){
            repository.save(projectList.get());
            return output.setExitCode(ExitCode.SUCCESS).setMessage("");
        }
        SetDoneDto setDoneDto = new SetDoneDto();
        setDoneDto.commandLine = "Could not find a task with an ID of ";
        setDoneDto.taskID = input.taskId;
        presenter.present(setDoneDto);

        return output.setExitCode(ExitCode.SUCCESS).setMessage("");
    }
}
