package com.example.finflow.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.finflow.data.local.entity.GoalEntity;
import java.util.List;

@Dao
public interface GoalDao {
    @Query("SELECT * FROM goals ORDER BY id DESC")
    List<GoalEntity> getAll();

    @Query("SELECT * FROM goals WHERE id = :id")
    GoalEntity getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(GoalEntity goal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<GoalEntity> goals);

    @Update
    void update(GoalEntity goal);

    @Delete
    void delete(GoalEntity goal);

    @Query("DELETE FROM goals")
    void deleteAll();
}
