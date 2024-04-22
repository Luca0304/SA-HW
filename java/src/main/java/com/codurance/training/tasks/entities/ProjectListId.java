package com.codurance.training.tasks.entities;

public record ProjectListId(String value) {
    public static ProjectListId of(String id){
        return new ProjectListId(id);
    }
}
