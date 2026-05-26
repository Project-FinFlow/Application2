package com.example.finflow.data.local.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "movements")
public class MovementEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String description;
    public String category;
    public String date;
    public String value;
    public String kind;

    public MovementEntity() {
    }

    @Ignore
    public MovementEntity(int id, String description, String category, String date, String value, String kind) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.date = date;
        this.value = value;
        this.kind = kind;
    }
}
