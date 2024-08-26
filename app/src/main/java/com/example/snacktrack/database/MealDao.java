package com.example.snacktrack.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.MealPlanner;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable addMealToFavorites(FavoriteMeal meal);

    @Query("SELECT * FROM FavoriteMeal WHERE userId = :userId")
    Flowable<List<FavoriteMeal>> getAllMeals(String userId);

    @Delete
    Completable deleteFavoriteMeal(FavoriteMeal meal);


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertPlannerMeal(MealPlanner meal);

    @Query("SELECT * FROM MealPlanner WHERE userId = :userId")
    Flowable<List<MealPlanner>> getAllPlannerMeals(String userId);


    @Delete
    Completable deletePlannerMeal(MealPlanner meal);

    @Query("SELECT COUNT() FROM favoritemeal WHERE userId= :userId and mealId = :mealId")
    Flowable<Integer> doesFavoriteMealExist(String userId, String mealId);

}
