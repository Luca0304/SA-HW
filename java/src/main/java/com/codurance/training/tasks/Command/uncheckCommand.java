package com.codurance.training.tasks.Command;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class uncheckCommand implements Command {
    public String id;
    private final TaskList taskList;
    public uncheckCommand(String id, TaskList taskList) {
        this.id = id;
        this.taskList = taskList;
    }
    private void setUnDone(String idString) {
        for (Map.Entry<String, List<Task>> project : taskList.tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (Objects.equals(task.getId(), idString)) {
                    task.setDone(false);
                    return;
                }
            }
        }
        taskList.out.printf("Could not find a task with an ID of %s.", idString);
        taskList.out.println();
    }
    public void uncheck(String idString) {
        setUnDone(idString);
    }

    @Override
    public void executeCommand() {
        uncheck(this.id);
    }

}
