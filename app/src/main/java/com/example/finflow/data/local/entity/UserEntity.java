package com.example.finflow.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {
    @PrimaryKey
    @NonNull
    public String email = "";
    public String initials;
    public String name;
    public String role;

    public UserEntity() {
    }

    @Ignore
    public UserEntity(@NonNull String email, String initials, String name, String role) {
        this.email = email;
        this.initials = initials;
        this.name = name;
        this.role = role;
    }
}
