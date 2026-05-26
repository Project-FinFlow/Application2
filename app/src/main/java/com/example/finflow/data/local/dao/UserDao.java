package com.example.finflow.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.finflow.data.local.entity.UserEntity;
import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users ORDER BY name ASC")
    List<UserEntity> getAll();

    @Query("SELECT * FROM users WHERE email = :email")
    UserEntity getByEmail(String email);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserEntity user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<UserEntity> users);

    @Update
    void update(UserEntity user);

    @Delete
    void delete(UserEntity user);

    @Query("DELETE FROM users")
    void deleteAll();
}
