package com.example.snacktrack.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.MealPlanner;


@Database(entities = {FavoriteMeal.class, MealPlanner.class}, version = 1)
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

