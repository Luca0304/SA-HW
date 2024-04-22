package com.codurance.training.tasks.usecases.port.output.error;

import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorDto;

public interface ErrorPresenter {
    void present(ErrorDto errorDto);
}
