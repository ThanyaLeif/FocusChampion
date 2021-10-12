package com.example.focuschampion.Models;

public class Attribute {
    private int id;
    private int taskId;
    private int skillId;

    public Attribute(int id, int taskId, int skillId) {
        this.id = id;
        this.taskId = taskId;
        this.skillId = skillId;
    }

    public Attribute() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
