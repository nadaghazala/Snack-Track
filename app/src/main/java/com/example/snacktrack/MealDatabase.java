package com.example.snacktrack;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class MealDatabase extends RoomDatabase {

    abstract MealDao mealDao();

    public static final String DATABASE_NAME = "meal_database";

    private static MealDatabase instance;

    public MealDatabase() {
    }

    public synchronized static MealDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MealDatabase.class, DATABASE_NAME).build();
        }
        return instance;
    }

}

