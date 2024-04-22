package com.codurance.training.tasks.usecases.port.output.add;

import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskDto;

public interface AddTaskPresenter {
    void present(AddTaskDto addTaskDto);
}
