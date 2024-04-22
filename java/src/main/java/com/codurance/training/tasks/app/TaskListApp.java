package com.codurance.training.tasks.app;


import com.codurance.training.tasks.adapters.controller.Execute;
import com.codurance.training.tasks.adapters.presenter.AddTaskConsolePresenter;
import com.codurance.training.tasks.adapters.presenter.ErrorConsolePresenter;
import com.codurance.training.tasks.adapters.presenter.HelpConsolePresenter;
import com.codurance.training.tasks.adapters.presenter.SetDoneConsolePresenter;
import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.ProjectListId;
import com.codurance.training.tasks.usecases.ProjectListInMemoryRepository;
import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorUseCase;
import com.codurance.training.tasks.usecases.port.input.projectList.help.HelpUseCase;
import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneUseCase;
import com.codurance.training.tasks.usecases.port.input.projectList.show.ShowUseCase;
import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskUseCase;
import com.codurance.training.tasks.usecases.port.output.ProjectListRepository;
import com.codurance.training.tasks.usecases.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class TaskListApp implements Runnable {
    private final BufferedReader in;
    private final PrintWriter out;
    private final ProjectListRepository repository;
    public static final ProjectListId DEFAULT_PROJECT_LIST_ID = ProjectListId.of("001");
    public final static ProjectList projectList = new ProjectList(DEFAULT_PROJECT_LIST_ID);

    private final ShowUseCase showUseCase;
    private final AddTaskUseCase addTaskUseCase;
    private final SetDoneUseCase setDoneUseCase;
    private final HelpUseCase helpUseCase;
    private final ErrorUseCase errorUseCase;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ProjectListRepository repository = new ProjectListInMemoryRepository();
        ShowUseCase showUseCase = new ShowService(repository);
        AddTaskUseCase addTaskUseCase = new AddTaskService(repository, new AddTaskConsolePresenter(out));
        SetDoneUseCase setDoneUseCase = new SetDoneService(repository, new SetDoneConsolePresenter(out));
        HelpUseCase helpUseCase = new HelpService(new HelpConsolePresenter(out));
        ErrorUseCase errorUseCase = new ErrorService(new ErrorConsolePresenter(out));
        repository.save(projectList);
        new TaskListApp(in, out, repository, showUseCase, addTaskUseCase, setDoneUseCase, helpUseCase, errorUseCase).run();
    }

    public TaskListApp(BufferedReader reader, PrintWriter writer, ProjectListRepository repository, ShowUseCase showUseCase, AddTaskUseCase addTaskUseCase, SetDoneUseCase setDoneUseCase, HelpUseCase helpUseCase, ErrorUseCase errorUseCase) {
        this.in = new BufferedReader(reader);
        this.out = new PrintWriter(writer);
        this.repository = repository;
        this.showUseCase = showUseCase;
        this.addTaskUseCase = addTaskUseCase;
        this.setDoneUseCase = setDoneUseCase;
        this.helpUseCase = helpUseCase;
        this.errorUseCase = errorUseCase;
    }

    public void run() {
        while (true) {
            out.printf("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals("quit")) {
                break;
            }
            new Execute(out, repository, showUseCase, addTaskUseCase, setDoneUseCase, helpUseCase, errorUseCase).execute(command);
        }
    }

}
