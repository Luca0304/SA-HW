package com.codurance.training.tasks.usecases.port.output.help;

import com.codurance.training.tasks.usecases.port.input.projectList.help.HelpDto;

public interface HelpPresenter {
    void present(HelpDto helpDto);
}
