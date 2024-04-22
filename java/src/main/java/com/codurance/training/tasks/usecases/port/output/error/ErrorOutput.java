package com.codurance.training.tasks.usecases.port.output.error;

import com.codurance.training.tasks.usecases.port.input.projectList.error.ErrorDto;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

public class ErrorOutput extends CqrsOutput<ErrorOutput> {
    public ErrorDto errorDto;

    public static ErrorOutput create() {
            return new ErrorOutput();
    }

}
