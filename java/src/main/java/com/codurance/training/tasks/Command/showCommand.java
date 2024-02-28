package com.codurance.training.tasks.Command;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.util.List;
import java.util.Map;

public class showCommand implements Command {
    private final TaskList taskList;
    public showCommand(TaskList taskList1) {
        this.taskList = taskList1;
    }
    private void show() {
        for (Map.Entry<String, List<Task>> project : taskList.tasks.entrySet()) {
            taskList.out.println(project.getKey());
            for (Task task : project.getValue()) {
                taskList.out.printf("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            taskList.out.println();
        }
    }

    @Override
    public void executeCommand() {
        show();
    }
}
