package com.codurance.training.tasks.usecases.port.input.projectList.error;

import com.codurance.training.tasks.usecases.port.output.error.ErrorOutput;
import tw.teddysoft.ezddd.cqrs.usecase.query.Query;

public interface ErrorUseCase extends Query<ErrorInput, ErrorOutput> {
}
