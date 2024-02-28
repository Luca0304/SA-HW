package com.codurance.training.tasks.Command;

import com.codurance.training.tasks.TaskList;

public class helpCommand implements Command {
    private final TaskList taskList;

    public helpCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    private void help() {
        taskList.out.println("Commands:");
        taskList.out.println("  show");
        taskList.out.println("  add project <project name>");
        taskList.out.println("  add task <project name> <task description>");
        taskList.out.println("  check <task ID>");
        taskList.out.println("  uncheck <task ID>");
        taskList.out.println();
    }

    @Override
    public void executeCommand() {
        help();
    }
}
