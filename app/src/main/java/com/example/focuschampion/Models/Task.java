package com.example.focuschampion.Models;

import java.util.UUID;

public class Task {
    public String name;
    public UUID id;
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
