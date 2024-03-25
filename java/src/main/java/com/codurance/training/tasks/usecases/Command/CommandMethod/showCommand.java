package com.codurance.training.tasks.usecases.Command.CommandMethod;

import com.codurance.training.tasks.entities.Project;
import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.Task;
import com.codurance.training.tasks.usecases.Command.Command;
import com.codurance.training.tasks.usecases.output.CommandOut;

public class showCommand implements Command {
    private final ProjectList projectList;
    private final CommandOut commandOut;
    public showCommand(ProjectList projectList) {
        this.projectList = projectList;
        this.commandOut = new CommandOut();
    }
    @Override
    public CommandOut executeCommand() {
        for (Project project : projectList.getProjects()) {
            commandOut.addCommandOut(project.getName().value());
            commandOut.addCommandOut("\r\n");
            for (Task task : project.getTasks()) {
                commandOut.addCommandOut(String.format("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId().toString(), task.getDescription()));
            }
            commandOut.addCommandOut("\r\n");
        }
        return this.commandOut;
    }
}
