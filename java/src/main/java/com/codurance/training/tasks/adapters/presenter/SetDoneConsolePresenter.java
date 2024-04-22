package com.codurance.training.tasks.adapters.presenter;

import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneDto;
import com.codurance.training.tasks.usecases.port.output.setdone.SetDonePresenter;

import java.io.PrintWriter;

public class SetDoneConsolePresenter implements SetDonePresenter {
    private final PrintWriter out;

    public SetDoneConsolePresenter(PrintWriter out){
        this.out = out;
    }

    @Override
    public void present(SetDoneDto setDoneDto) {
        out.print(setDoneDto.commandLine);
        out.println(setDoneDto.taskID);
    }
}
