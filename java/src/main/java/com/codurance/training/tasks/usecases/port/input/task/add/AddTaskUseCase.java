package com.codurance.training.tasks.usecases.port.input.task.add;

import com.codurance.training.tasks.usecases.port.output.add.AddTaskOutput;
import tw.teddysoft.ezddd.cqrs.usecase.query.Query;

public interface AddTaskUseCase extends Query<AddTaskInput, AddTaskOutput> {
}
