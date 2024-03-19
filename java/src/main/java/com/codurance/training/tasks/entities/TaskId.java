package com.codurance.training.tasks.entities;

public record TaskId(long value) {
    public static TaskId of(long id) {
        return new TaskId(id);
    }
    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
