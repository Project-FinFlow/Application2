package com.example.finflow.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.finflow.data.local.entity.CategoryEntity;
import java.util.List;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM categories ORDER BY name ASC")
    List<CategoryEntity> getAll();

    @Query("SELECT * FROM categories WHERE kind = :kind ORDER BY name ASC")
    List<CategoryEntity> getByKind(String kind);

    @Query("SELECT * FROM categories WHERE id = :id")
    CategoryEntity getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(CategoryEntity category);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CategoryEntity> categories);

    @Update
    void update(CategoryEntity category);

    @Delete
    void delete(CategoryEntity category);

    @Query("DELETE FROM categories")
    void deleteAll();
}
