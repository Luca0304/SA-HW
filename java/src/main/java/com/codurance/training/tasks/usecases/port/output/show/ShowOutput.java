package com.codurance.training.tasks.usecases.port.output.show;

import com.codurance.training.tasks.usecases.port.input.projectList.show.ProjectListDto;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

public class ShowOutput extends CqrsOutput<ShowOutput> {
    public ProjectListDto projectListDto;
}
