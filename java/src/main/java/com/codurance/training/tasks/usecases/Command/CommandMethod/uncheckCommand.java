package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.Project;
import com.codurance.training.tasks.entities.Task;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

public class uncheckCommand implements Command {
    public String id;
    private final ProjectList projectList;
    private final CommandOut commandOut;
    public uncheckCommand(String id, ProjectList projectList) {
        this.id = id;
        this.projectList = projectList;
        this.commandOut = new CommandOut();
    }
    @Override
    public CommandOut executeCommand() {
        for (Project project : projectList.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getId().toString().equals(this.id)) {
                    task.setDone(false);
                    return this.commandOut;
                }
            }
        }
        commandOut.addCommandOut(String.format("Could not find a task with an ID of %s.", this.id));
        commandOut.addCommandOut("\n");
        return this.commandOut;
    }

}
