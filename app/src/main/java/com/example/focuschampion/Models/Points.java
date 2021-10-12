package com.example.focuschampion.Models;

public class Points {
    private int id;
    private int skillId;
    private String userId;
    private int accumulatedPoints;

    public Points(int id, int skillId, String userId, int accumulatedPoints) {
        this.id = id;
        this.skillId = skillId;
        this.userId = userId;
        this.accumulatedPoints = accumulatedPoints;
    }

    public Points() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public void setAccumulatedPoints(int accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }
}
