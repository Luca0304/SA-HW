package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.Project;
import com.codurance.training.tasks.entities.Task;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class uncheckCommand implements Command {
    public String id;
    private final ProjectList projectList;
    private final CommandOut commandOut;
    public uncheckCommand(String id, ProjectList projectList) {
        this.id = id;
        this.projectList = projectList;
        this.commandOut = new CommandOut();
    }
    private void setUnDone(String idString) {
        for (Map.Entry<Project, List<Task>> projectListEntry : projectList.entrySet()) {
            for (Task task : projectListEntry.getValue()) {
                if (task.getId().toString().equals(idString)) {
                    task.setDone(false);
                    return;
                }
            }
        }
        commandOut.addCommandOut(String.format("Could not find a task with an ID of %s.", idString));
        commandOut.addCommandOut("\n");
    }
    public void uncheck(String idString) {
        setUnDone(idString);
    }

    @Override
    public CommandOut executeCommand() {
        uncheck(this.id);
        return this.commandOut;
    }

}
