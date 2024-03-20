package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.entities.Project;
import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.Task;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

import java.util.List;
import java.util.Map;

public class showCommand implements Command {
    private final ProjectList projectList;
    private final CommandOut commandOut;
    public showCommand(ProjectList projectList) {
        this.projectList = projectList;
        this.commandOut = new CommandOut();
    }
    private void show() {
        for (Map.Entry<Project, List<Task>> projectListEntry : projectList.entrySet()) {
            commandOut.addCommandOut(projectListEntry.getKey().getName());
            commandOut.addCommandOut("\r\n");
            for (Task task : projectListEntry.getValue()) {
                commandOut.addCommandOut(String.format("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId().toString(), task.getDescription()));
            }
            commandOut.addCommandOut("\r\n");
        }
    }
    @Override
    public CommandOut executeCommand() {
        show();
        return this.commandOut;
    }
}
