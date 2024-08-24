package com.example.snacktrack;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface LocalDataSource {

    Completable insertFavoriteMeal(FavoriteMeal meal);
    Flowable<List<FavoriteMeal>> getAllFavouriteMeals(String userId);
    Completable deleteFavoriteMeal(FavoriteMeal meal);
    Flowable<Integer> doesFavoriteMealExist(String userId, String mealId);

    Completable insertPlannerMeal(MealPlanner meal);
    Flowable<List<MealPlanner>> getAllCalenderMeals(String userId );
    Completable deletePlannerMeal(MealPlanner meal);

}
