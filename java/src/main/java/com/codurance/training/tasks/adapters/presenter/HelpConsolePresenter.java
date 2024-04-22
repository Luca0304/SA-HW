package com.codurance.training.tasks.adapters.presenter;

import com.codurance.training.tasks.usecases.port.input.projectList.help.HelpDto;
import com.codurance.training.tasks.usecases.port.output.help.HelpPresenter;

import java.io.PrintWriter;

public class HelpConsolePresenter implements HelpPresenter {

    private final PrintWriter out;

    public HelpConsolePresenter(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void present(HelpDto helpDto) {
        out.println(helpDto.heading);
        for(var command : helpDto.commands)
            out.printf("  %s%n", command);
        out.println();
    }
}
