package com.codurance.training.tasks.usecases.port.input.task.add;

import tw.teddysoft.ezddd.core.usecase.Input;

public class AddTaskInput implements Input {
    public String projectListId;
    public String description;
    public String projectName;
}
