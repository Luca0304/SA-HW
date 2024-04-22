package com.codurance.training.tasks.usecases.port.output.setdone;

import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneDto;

public interface SetDonePresenter {
    void present(SetDoneDto setDoneDto);
}
