package com.codurance.training.tasks.adapters.controller;

import com.codurance.training.tasks.adapters.presenter.*;
import com.codurance.training.tasks.app.TaskListApp;
import com.codurance.training.tasks.usecases.port.input.project.add.AddProjectInput;
import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorInput;
import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorUseCase;
import com.codurance.training.tasks.usecases.port.input.projectList.help.HelpUseCase;
import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneInput;
import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneUseCase;
import com.codurance.training.tasks.usecases.port.input.projectList.show.ShowInput;
import com.codurance.training.tasks.usecases.port.input.projectList.show.ShowUseCase;
import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskInput;
import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskUseCase;
import com.codurance.training.tasks.usecases.port.output.ProjectListRepository;
import com.codurance.training.tasks.usecases.port.output.show.ShowOutput;
import com.codurance.training.tasks.usecases.port.output.show.ShowPresenter;
import com.codurance.training.tasks.usecases.service.*;
import tw.teddysoft.ezddd.core.usecase.Input;

import java.io.PrintWriter;

public class Execute {
    private final PrintWriter out;
    private final ProjectListRepository repository;
    private final ShowUseCase showUseCase;
    private final AddTaskUseCase addTaskUseCase;
    private final SetDoneUseCase setDoneUseCase;
    private final HelpUseCase helpUseCase;
    private final ErrorUseCase errorUseCase;

    public Execute(PrintWriter out, ProjectListRepository repository, ShowUseCase showUseCase, AddTaskUseCase addTaskUseCase, SetDoneUseCase setDoneUseCase, HelpUseCase helpUseCase, ErrorUseCase errorUseCase) {
        this.out = out;
        this.repository = repository;
        this.showUseCase = showUseCase;
        this.addTaskUseCase = addTaskUseCase;
        this.setDoneUseCase = setDoneUseCase;
        this.helpUseCase = helpUseCase;
        this.errorUseCase = errorUseCase;
    }

    public void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                ShowInput showInput = new ShowInput();
                showInput.projectListId = TaskListApp.DEFAULT_PROJECT_LIST_ID.value();
                ShowOutput output = showUseCase.execute(showInput);
                ShowPresenter presenter = new ShowConsolePresenter(out);
                presenter.present(output.projectListDto);
                break;
            case "add":
                String[] subcommandRest = commandRest[1].split(" ", 2);
                String subcommand = subcommandRest[0];
                if (subcommand.equals("project")) {
                    AddProjectInput input = new AddProjectInput();
                    input.projectListId = TaskListApp.DEFAULT_PROJECT_LIST_ID.value();
                    input.projectName = subcommandRest[1];
                    new AddProjectService(repository).execute(input);
                } else if (subcommand.equals("task")) {
                    String[] projectTask = subcommandRest[1].split(" ", 2);
                    AddTaskInput addTaskInput = new AddTaskInput();
                    addTaskInput.projectListId = TaskListApp.DEFAULT_PROJECT_LIST_ID.value();
                    addTaskInput.projectName = projectTask[0];
                    addTaskInput.description = projectTask[1];
                    addTaskUseCase.execute(addTaskInput);
                    break;
                }
                break;
            case "check":
                SetDoneInput setDoneInput = new SetDoneInput();
                setDoneInput.projectListId = TaskListApp.DEFAULT_PROJECT_LIST_ID.value();
                setDoneInput.taskId = commandRest[1];
                setDoneInput.done = true;
                setDoneUseCase.execute(setDoneInput);
                break;
            case "uncheck":
                setDoneInput = new SetDoneInput();
                setDoneInput.projectListId = TaskListApp.DEFAULT_PROJECT_LIST_ID.value();
                setDoneInput.taskId = commandRest[1];
                setDoneInput.done = false;
                setDoneUseCase.execute(setDoneInput);
                break;
            case "help":
                helpUseCase.execute(new Input.NullInput());
                break;
            default:
                ErrorInput errorInput = new ErrorInput();
                errorInput.errorInput = command;
                errorUseCase.execute(errorInput);
                break;
        }
    }
}
