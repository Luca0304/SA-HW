package com.codurance.training.tasks.usecases.port.output.show;


import com.codurance.training.tasks.usecases.port.input.projectList.show.ProjectListDto;

public interface ShowPresenter {
    void present(ProjectListDto projectListDto);
}
