package com.codurance.training.tasks.usecases.port.input.projectList.show;

import com.codurance.training.tasks.usecases.port.output.show.ShowOutput;
import tw.teddysoft.ezddd.cqrs.usecase.query.Query;

public interface ShowUseCase
        extends Query<ShowInput, ShowOutput> {
}
