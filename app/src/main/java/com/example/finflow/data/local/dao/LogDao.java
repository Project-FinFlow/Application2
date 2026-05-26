package com.example.finflow.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.finflow.data.local.entity.LogEntity;
import java.util.List;

@Dao
public interface LogDao {
    @Query("SELECT * FROM logs ORDER BY id DESC")
    List<LogEntity> getAll();

    @Query("SELECT * FROM logs WHERE status = :status ORDER BY id DESC")
    List<LogEntity> getByStatus(String status);

    @Query("SELECT * FROM logs WHERE id = :id")
    LogEntity getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(LogEntity log);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<LogEntity> logs);

    @Update
    void update(LogEntity log);

    @Delete
    void delete(LogEntity log);

    @Query("DELETE FROM logs")
    void deleteAll();
}
