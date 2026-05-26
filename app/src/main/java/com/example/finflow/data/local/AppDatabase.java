package com.example.finflow.data.local;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.finflow.data.local.dao.CategoryDao;
import com.example.finflow.data.local.dao.GoalDao;
import com.example.finflow.data.local.dao.LogDao;
import com.example.finflow.data.local.dao.MovementDao;
import com.example.finflow.data.local.dao.UserDao;
import com.example.finflow.data.local.entity.CategoryEntity;
import com.example.finflow.data.local.entity.GoalEntity;
import com.example.finflow.data.local.entity.LogEntity;
import com.example.finflow.data.local.entity.MovementEntity;
import com.example.finflow.data.local.entity.UserEntity;

@Database(
    entities = {
        MovementEntity.class,
        CategoryEntity.class,
        GoalEntity.class,
        UserEntity.class,
        LogEntity.class
    },
    version = 1,
    exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase instance;

    public abstract MovementDao movementDao();
    public abstract CategoryDao categoryDao();
    public abstract GoalDao goalDao();
    public abstract UserDao userDao();
    public abstract LogDao logDao();

    public static AppDatabase getDatabase(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        "finflow_database"
                    ).build();
                }
            }
        }

        return instance;
    }
}
