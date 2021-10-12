package com.example.focuschampion.Models;

public class Attributes {
    public int id;
    public int taskId;
    public int skillId;

    public Attributes(int id, int taskId, int skillId) {
        this.id = id;
        this.taskId = taskId;
        this.skillId = skillId;
    }

    public Attributes() {
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
