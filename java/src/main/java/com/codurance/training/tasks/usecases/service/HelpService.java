package com.codurance.training.tasks.usecases.service;


import com.codurance.training.tasks.usecases.port.input.projectList.help.HelpDto;
import com.codurance.training.tasks.usecases.port.output.help.HelpOutput;
import com.codurance.training.tasks.usecases.port.input.projectList.help.HelpUseCase;
import com.codurance.training.tasks.usecases.port.output.help.HelpPresenter;
import tw.teddysoft.ezddd.core.usecase.ExitCode;
import tw.teddysoft.ezddd.core.usecase.Input;


public class HelpService implements HelpUseCase {
    private final HelpPresenter presenter;
    public HelpService(HelpPresenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public HelpOutput execute(Input.NullInput input) {

        HelpDto helpDto = new HelpDto();
        helpDto.heading = "Commands:";
        helpDto.commands.add("show");
        helpDto.commands.add("add project <project name>");
        helpDto.commands.add("add task <project name> <task description>");
        helpDto.commands.add("check <task ID>");
        helpDto.commands.add("uncheck <task ID>");
        presenter.present(helpDto);

        var output = HelpOutput.create();
        output.helpDto = helpDto;
        return output.setExitCode(ExitCode.SUCCESS).setMessage("");
    }
}
