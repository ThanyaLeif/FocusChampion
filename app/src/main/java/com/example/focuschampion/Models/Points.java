package com.example.focuschampion.Models;

public class Points {
    public int skillId;
    public String userId;
    public int accumulatedPoints;

    public Points(int skillId, String userId, int accumulatedPoints) {
        this.skillId = skillId;
        this.userId = userId;
        this.accumulatedPoints = accumulatedPoints;
    }

    public Points() {
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
