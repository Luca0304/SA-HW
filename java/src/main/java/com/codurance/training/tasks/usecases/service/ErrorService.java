package com.codurance.training.tasks.usecases.service;

import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorDto;
import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorInput;
import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorUseCase;
import com.codurance.training.tasks.usecases.port.output.error.ErrorOutput;
import com.codurance.training.tasks.usecases.port.output.error.ErrorPresenter;
import tw.teddysoft.ezddd.core.usecase.ExitCode;

public class ErrorService implements ErrorUseCase {

    private final ErrorPresenter presenter;

    public ErrorService(ErrorPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public ErrorOutput execute(ErrorInput input) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.commandLine = "I don't know what the command ";
        errorDto.inputError = input.errorInput;
        presenter.present(errorDto);

        var output = ErrorOutput.create();
        output.errorDto = errorDto;
        return output.setExitCode(ExitCode.SUCCESS).setMessage("");
    }
}
