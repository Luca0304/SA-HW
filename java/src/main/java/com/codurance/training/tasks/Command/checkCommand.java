package com.codurance.training.tasks.Command;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class checkCommand implements Command {
    public String id;
    private final TaskList taskList;
    public checkCommand(String id, TaskList taskList) {
        this.id = id;
        this.taskList = taskList;
    }
    private void setDone(String idString) {
        for (Map.Entry<String, List<Task>> project : taskList.tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (Objects.equals(task.getId(), idString)) {
                    task.setDone(true);
                    return;
                }
            }
        }
        taskList.out.printf("Could not find a task with an ID of %s.", idString);
        taskList.out.println();
    }
    private void check(String idString) {
        setDone(idString);
    }

    @Override
    public void executeCommand() {
        check(this.id);
    }
}
