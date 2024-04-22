package com.codurance.training.tasks.adapters.presenter;

import com.codurance.training.tasks.usecases.port.input.projectList.show.ProjectDto;
import com.codurance.training.tasks.usecases.port.input.projectList.show.ProjectListDto;
import com.codurance.training.tasks.usecases.port.input.projectList.show.TaskDto;
import com.codurance.training.tasks.usecases.port.output.show.ShowPresenter;

import java.io.PrintWriter;

public class ShowConsolePresenter implements ShowPresenter {

    private final PrintWriter out;

    public ShowConsolePresenter(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void present(ProjectListDto projectListDto) {
        for (ProjectDto project : projectListDto.projectDots)
        {
            out.println(project.name);
            for (TaskDto task : project.taskDtos) {
                out.printf("    [%c] %s: %s%n", (task.done? 'x' : ' '), task.id, task.description);
            }
            out.println();
        }
    }
}
