package com.example.finflow.data.local.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "logs")
public class LogEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String event;
    public String actor;
    public String date;
    public String status;

    public LogEntity() {
    }

    @Ignore
    public LogEntity(int id, String event, String actor, String date, String status) {
        this.id = id;
        this.event = event;
        this.actor = actor;
        this.date = date;
        this.status = status;
    }
}
