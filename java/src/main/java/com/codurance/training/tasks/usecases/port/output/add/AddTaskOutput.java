package com.codurance.training.tasks.usecases.port.output.add;

import com.codurance.training.tasks.usecases.port.input.task.add.AddTaskDto;
import com.codurance.training.tasks.usecases.port.output.setdone.SetDoneOutput;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

public class AddTaskOutput extends CqrsOutput<AddTaskOutput> {
    public AddTaskDto addTaskDto;
    public static AddTaskOutput create(){
        return new AddTaskOutput();
    }
}
