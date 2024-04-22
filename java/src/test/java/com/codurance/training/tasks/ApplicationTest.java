package com.codurance.training.tasks;

import com.codurance.training.tasks.adapters.presenter.AddTaskConsolePresenter;
import com.codurance.training.tasks.adapters.presenter.ErrorConsolePresenter;
import com.codurance.training.tasks.adapters.presenter.HelpConsolePresenter;
import com.codurance.training.tasks.adapters.presenter.SetDoneConsolePresenter;
import com.codurance.training.tasks.app.TaskListApp;
import com.codurance.training.tasks.usecases.ProjectListInMemoryRepository;
import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorUseCase;
import com.codurance.training.tasks.usecases.port.input.projectList.help.HelpUseCase;
import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneUseCase;
import com.codurance.training.tasks.usecases.port.input.projectList.show.ShowUseCase;
import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskUseCase;
import com.codurance.training.tasks.usecases.port.output.ProjectListRepository;
import com.codurance.training.tasks.usecases.service.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static java.lang.System.lineSeparator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public final class ApplicationTest {
    public static final String PROMPT = "> ";
    private final PipedOutputStream inStream = new PipedOutputStream();
    private final PrintWriter inWriter = new PrintWriter(inStream, true);

    private final PipedInputStream outStream = new PipedInputStream();
    private final BufferedReader outReader = new BufferedReader(new InputStreamReader(outStream));

    private Thread applicationThread;

    public ApplicationTest() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new PipedInputStream(inStream)));
        PrintWriter out = new PrintWriter(new PipedOutputStream(outStream), true);
        ProjectListRepository repository = new ProjectListInMemoryRepository();
        ShowUseCase showUseCase = new ShowService(repository);
        AddTaskUseCase addTaskUseCase = new AddTaskService(repository, new AddTaskConsolePresenter(out));
        SetDoneUseCase setDoneUseCase = new SetDoneService(repository, new SetDoneConsolePresenter(out));
        HelpUseCase helpUseCase = new HelpService(new HelpConsolePresenter(out));
        ErrorUseCase errorUseCase = new ErrorService(new ErrorConsolePresenter(out));
        repository.save(TaskListApp.projectList);
        TaskListApp taskListApp = new TaskListApp(in, out, repository, showUseCase, addTaskUseCase, setDoneUseCase, helpUseCase, errorUseCase);
        applicationThread = new Thread(taskListApp);
    }

    @Before public void
    start_the_application() {
        applicationThread.start();
    }

    @After public void
    kill_the_application() throws IOException, InterruptedException {
        if (!stillRunning()) {
            return;
        }

        Thread.sleep(1000);
        if (!stillRunning()) {
            return;
        }

        applicationThread.interrupt();
        throw new IllegalStateException("The application is still running.");
    }

    @Test(timeout = 1000) public void
    it_works() throws IOException {
        execute("show");

        execute("add project secrets");
        execute("add task secrets Eat more donuts.");
        execute("add task secrets Destroy all humans.");

        execute("show");
        readLines(
            "secrets",
            "    [ ] 1: Eat more donuts.",
            "    [ ] 2: Destroy all humans.",
            ""
        );

        execute("add project training");
        execute("add task training Four Elements of Simple Design");
        execute("add task training SOLID");
        execute("add task training Coupling and Cohesion");
        execute("add task training Primitive Obsession");
        execute("add task training Outside-In TDD");
        execute("add task training Interaction-Driven Design");

        execute("check 1");
        execute("check 3");
        execute("check 5");
        execute("check 6");

        execute("show");
        readLines(
                "secrets",
                "    [x] 1: Eat more donuts.",
                "    [ ] 2: Destroy all humans.",
                "",
                "training",
                "    [x] 3: Four Elements of Simple Design",
                "    [ ] 4: SOLID",
                "    [x] 5: Coupling and Cohesion",
                "    [x] 6: Primitive Obsession",
                "    [ ] 7: Outside-In TDD",
                "    [ ] 8: Interaction-Driven Design",
                ""
        );

        execute("quit");
    }

    private void execute(String command) throws IOException {
        read(PROMPT);
        write(command);
    }

    private void read(String expectedOutput) throws IOException {
        int length = expectedOutput.length();
        char[] buffer = new char[length];
        outReader.read(buffer, 0, length);
        assertThat(String.valueOf(buffer), is(expectedOutput));
    }

    private void readLines(String... expectedOutput) throws IOException {
        for (String line : expectedOutput) {
            read(line + lineSeparator());
        }
    }

    private void write(String input) {
        inWriter.println(input);
    }

    private boolean stillRunning() {
        return applicationThread != null && applicationThread.isAlive();
    }
}
