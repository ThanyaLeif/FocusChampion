package com.example.focuschampion.Models;

public class Task {
    private int id;
    private String name;
    private String description;
    private String userId;
    private TaskState state;
    private DifficultyLevel difficulty;

    public enum TaskState{
        ACTIVE, FINISHED, CANCELED
    }

    public enum DifficultyLevel{
        EASY, MEDIUM, HARD;
    }

    public Task(int id, String name, String description, String userId,
                TaskState state, DifficultyLevel difficulty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.state = state;
        this.difficulty = difficulty;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    public String getStringState(){
        String state = "";
        switch (this.state) {
            case ACTIVE:
                state = "ACTIVE";
                break;
            case CANCELED:
                state = "CANCELED";
                break;
            case FINISHED:
                state = "FINISHED";
                break;
        }
        return state;
    }

    public String getStringDifficulty(){
        String difficulty = "";
        switch (this.difficulty){
            case EASY:
                difficulty = "EASY";
                break;
            case MEDIUM:
                difficulty = "MEDIUM";
                break;
            case HARD:
                difficulty = "HARD";
                break;
        }
        return difficulty;
    }
}
