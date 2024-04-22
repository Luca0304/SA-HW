package com.codurance.training.tasks.usecases.port.input.projectList.setdone;

import tw.teddysoft.ezddd.core.usecase.Input;

public class SetDoneInput implements Input {
    public String projectListId;
    public String taskId;
    public boolean done;
}
