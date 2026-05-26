package com.example.finflow.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.finflow.data.local.entity.MovementEntity;
import java.util.List;

@Dao
public interface MovementDao {
    @Query("SELECT * FROM movements ORDER BY id DESC")
    List<MovementEntity> getAll();

    @Query("SELECT * FROM movements WHERE kind = :kind ORDER BY id DESC")
    List<MovementEntity> getByKind(String kind);

    @Query("SELECT * FROM movements WHERE id = :id")
    MovementEntity getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MovementEntity movement);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MovementEntity> movements);

    @Update
    void update(MovementEntity movement);

    @Delete
    void delete(MovementEntity movement);

    @Query("DELETE FROM movements")
    void deleteAll();
}
