package com.example.finflow.data.local.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "goals")
public class GoalEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String current;
    public String target;
    public String dueDate;
    public float progress;

    public GoalEntity() {
    }

    @Ignore
    public GoalEntity(int id, String name, String current, String target, String dueDate, float progress) {
        this.id = id;
        this.name = name;
        this.current = current;
        this.target = target;
        this.dueDate = dueDate;
        this.progress = progress;
    }
}
