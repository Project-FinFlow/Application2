package com.example.finflow.data.local.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")
public class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String description;
    public String kind;

    public CategoryEntity() {
    }

    @Ignore
    public CategoryEntity(int id, String name, String description, String kind) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.kind = kind;
    }
}
