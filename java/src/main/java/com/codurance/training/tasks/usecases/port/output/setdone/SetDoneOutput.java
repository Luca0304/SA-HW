package com.codurance.training.tasks.usecases.port.output.setdone;

import com.codurance.training.tasks.usecases.port.input.projectList.setdone.SetDoneDto;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

public class SetDoneOutput extends CqrsOutput<SetDoneOutput> {
    public SetDoneDto setDoneDto;
    public static SetDoneOutput create(){
        return new SetDoneOutput();
    }
}
