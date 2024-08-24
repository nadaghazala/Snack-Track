package com.example.snacktrack;


import android.content.Context;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public class DatabaseHandler implements LocalDataSource{

    Context context;
    private static DatabaseHandler databaseHandler;
    private MealDao mealDao;

    private DatabaseHandler(android.content.Context context) {
        this.context = context;
        mealDao = MealDatabase.getInstance(context).mealDao();
    }

    public static DatabaseHandler getInstance(Context context) {
        if (databaseHandler == null) {
            databaseHandler = new DatabaseHandler(context);
        }
        return databaseHandler;
    }


    @Override
    public Completable insertFavoriteMeal(FavoriteMeal meal) {
        return mealDao.insertMeal(meal);
    }

    @Override
    public Flowable<List<FavoriteMeal>> getAllFavouriteMeals(String userId) {
        return mealDao.getAllMeals(userId);
    }

    @Override
    public Completable deleteFavoriteMeal(FavoriteMeal meal) {
        return mealDao.deleteFavoriteMeal(meal);
    }

    @Override
    public Flowable<Integer> doesFavoriteMealExist(String userId, String mealId) {
        return mealDao.doesFavoriteMealExist(userId,mealId);
    }

    @Override
    public Completable insertPlannerMeal(MealPlanner meal) {
        return mealDao.insertPlannerMeal(meal);
    }

    @Override
    public Flowable<List<MealPlanner>> getAllCalenderMeals(String userId) {
        return mealDao.getAllPlannerMeals(userId);
    }

    @Override
    public Completable deletePlannerMeal(MealPlanner meal) {
        return mealDao.deletePlannerMeal(meal);
    }
}
