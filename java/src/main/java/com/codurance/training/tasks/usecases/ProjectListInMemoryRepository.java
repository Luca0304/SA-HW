package com.codurance.training.tasks.usecases;

import com.codurance.training.tasks.entities.ProjectList;
import com.codurance.training.tasks.entities.ProjectListId;
import com.codurance.training.tasks.usecases.port.output.ProjectListRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectListInMemoryRepository implements ProjectListRepository<ProjectListId> {

    private final List<ProjectList> store = new ArrayList<>();

    @Override
    public Optional<ProjectList> findById(ProjectListId projectListId) {
        return store.stream().filter( x -> x.getId().equals(projectListId)).findFirst();
    }

    @Override
    public void save(ProjectList projectList) {
        store.remove(projectList);
        store.add(projectList);
    }
}
