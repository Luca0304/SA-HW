package com.codurance.training.tasks.usecases.port.output;

import com.codurance.training.tasks.entities.ProjectList;

import java.util.Optional;

public interface ProjectListRepository<ID> {

    Optional<ProjectList> findById(ID id);
    void save(ProjectList projectList);
}
