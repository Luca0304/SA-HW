package com.codurance.training.tasks.adapters.presenter;

import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskDto;
import com.codurance.training.tasks.usecases.port.output.add.AddTaskPresenter;

import java.io.PrintWriter;

public class AddTaskConsolePresenter implements AddTaskPresenter {
    private final PrintWriter out;

    public AddTaskConsolePresenter(PrintWriter out){
        this.out = out;
    }

    @Override
    public void present(AddTaskDto addTaskDto) {
        out.print(addTaskDto.commandLine);
        out.println(addTaskDto.projectName);
    }
}
