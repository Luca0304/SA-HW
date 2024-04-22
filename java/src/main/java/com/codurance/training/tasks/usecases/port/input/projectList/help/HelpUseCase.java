package com.codurance.training.tasks.usecases.port.input.projectList.help;

import com.codurance.training.tasks.usecases.port.output.help.HelpOutput;
import tw.teddysoft.ezddd.core.usecase.Input;
import tw.teddysoft.ezddd.cqrs.usecase.query.Query;

public interface HelpUseCase extends Query<Input.NullInput, HelpOutput> {
}
