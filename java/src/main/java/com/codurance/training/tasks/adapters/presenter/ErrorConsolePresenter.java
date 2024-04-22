package com.codurance.training.tasks.adapters.presenter;

import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorDto;
import com.codurance.training.tasks.usecases.port.output.error.ErrorPresenter;

import java.io.PrintWriter;

public class ErrorConsolePresenter implements ErrorPresenter {
    private final PrintWriter out;

    public ErrorConsolePresenter(PrintWriter out){
        this.out = out;
    }

    @Override
    public void present(ErrorDto errorDto) {
        out.print(errorDto.commandLine);
        out.println(errorDto.inputError);
    }
}
