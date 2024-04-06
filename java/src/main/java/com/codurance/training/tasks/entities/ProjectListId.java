package com.codurance.training.tasks.entities;

public record ProjectListId(String id) {
    public static ProjectListId of(String id){
        return new ProjectListId(id);
    }
}
