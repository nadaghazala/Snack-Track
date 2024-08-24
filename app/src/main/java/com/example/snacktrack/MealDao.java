package com.example.snacktrack;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertMeal(FavoriteMeal meal);

    @Query("SELECT * FROM FavoriteMeal WHERE userId = :userId")
    Flowable<List<FavoriteMeal>> getAllMeals(String userId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertPlannerMeal(MealPlanner meal);

    @Query("SELECT * FROM FavoriteMeal WHERE userId = :userId")
    Flowable<List<MealPlanner>> getAllPlannerMeals(String userId);

    @Delete
    Completable deleteFavoriteMeal(FavoriteMeal meal);

    @Delete
    Completable deletePlannerMeal(MealPlanner meal);

    @Query("SELECT COUNT() FROM favoritemeal WHERE userId= :userId and mealId = :mealId")
    Flowable<Integer> doesFavoriteMealExist(String userId, String mealId);

}
