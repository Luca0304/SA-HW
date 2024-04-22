package com.codurance.training.tasks.usecases.port.output.help;

import com.codurance.training.tasks.usecases.port.input.projectList.help.HelpDto;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

public class HelpOutput extends CqrsOutput<HelpOutput> {
    public HelpDto helpDto;
    public static HelpOutput create(){
        return new HelpOutput();
    }
}
