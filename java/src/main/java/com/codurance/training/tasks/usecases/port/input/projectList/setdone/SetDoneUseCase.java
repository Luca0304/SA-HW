package com.codurance.training.tasks.usecases.port.input.projectList.setdone;

import com.codurance.training.tasks.usecases.port.output.setdone.SetDoneOutput;
import tw.teddysoft.ezddd.cqrs.usecase.query.Query;

public interface SetDoneUseCase extends Query<SetDoneInput, SetDoneOutput> {
}
