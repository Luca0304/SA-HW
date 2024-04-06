package com.codurance.training.tasks.entities;

import tw.teddysoft.ezddd.core.entity.ValueObject;

public record TaskId(long value) implements ValueObject {
    public static TaskId of(long id) {
        return new TaskId(id);
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
