package com.codurance.training.tasks.entities;

import java.util.List;

public class ReadOnlyProject extends Project{
    public ReadOnlyProject(ProjectName name, List<Task> tasks){
        super(name, tasks);
    }
}
