package com.codurance.training.tasks.usecases.port.input.project.add;

import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

import tw.teddysoft.ezddd.cqrs.usecase.command.Command;

public interface AddProjectUseCase
        extends Command<AddProjectInput, CqrsOutput> {
}
