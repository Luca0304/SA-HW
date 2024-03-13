package com.codurance.training.tasks.adapters.repository;

import com.codurance.training.tasks.entities.Project;
import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.Task;

import java.util.List;
import java.util.Map;

public class Storage {

    private ProjectList projectList;

    public Storage(){

    }

    public void save(ProjectList projectList) {
        this.projectList = projectList;
    }

    public void out(){
        for (Map.Entry<Project, List<Task>> entry : projectList.getTasks().entrySet()) {
            Project project = entry.getKey();
            System.out.println("Project: " + project.getName());
            List<Task> tasks = entry.getValue();
            for (Task task : tasks) {
                System.out.println("[ " + (task.isDone() ? 'x' : ' ') + " ] " + task.getId().getTaskId() +"  Task: " + task.getDescription());
            }
        }
    }
}
