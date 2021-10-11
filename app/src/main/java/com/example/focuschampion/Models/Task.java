package com.example.focuschampion.Models;

public class Task {
    public int id;
    public String name;
    public String description;
    public String userId;
    public TaskState state;
    public DifficultyLevel difficulty;

    private enum DifficultyLevel{
        EASY, MEDIUM, HARD;
    }

    private enum TaskState{
        ACTIVE, FINISHED, CANCELED
    }
}
