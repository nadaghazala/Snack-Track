package com.example.snacktrack.mealdetails.repository;

import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.MealPlanner;
import com.example.snacktrack.MyRetrofitBuilder;
import com.example.snacktrack.categorylistexpanded.model.MealsList;
import com.example.snacktrack.database.LocalDataSource;

import com.example.snacktrack.mealdetails.presenter.MealDetailsCallback;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealDetailsRepository implements  LocalDataSource{
    MyRetrofitBuilder myRetrofitBuilder;
    MealDetailsService mealDetailsService;
    LocalDataSource localDataSource;

    public MealDetailsRepository(LocalDataSource localDataSource) {
        this.myRetrofitBuilder = new MyRetrofitBuilder();
        this.mealDetailsService= myRetrofitBuilder.getRetrofit().create(MealDetailsService.class);
        this.localDataSource = localDataSource;
    }

    public void getMealDetails(String id, MealDetailsCallback callback) {
        Call<MealsList> call = mealDetailsService.getMealDetails(id);
        call.enqueue(new Callback<MealsList>() {
            @Override
            public void onResponse(Call<MealsList> call, Response<MealsList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().meals.get(0));
                } else {
                    callback.onError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MealsList> call, Throwable throwable) {
                callback.onError("Error: " + throwable.getMessage());
            }
        });

    }



    @Override
    public Completable addMealtoFavorites(FavoriteMeal meal) {
        return localDataSource.addMealtoFavorites(meal);
    }

    @Override
    public Flowable<List<FavoriteMeal>> getAllFavouriteMeals(String userId) {
        return localDataSource.getAllFavouriteMeals(userId);
    }

    @Override
    public Completable deleteFavoriteMeal(FavoriteMeal meal) {
        return localDataSource.deleteFavoriteMeal(meal);
    }

    @Override
    public Flowable<Integer> doesFavoriteMealExist(String userId, String mealId) {
        return localDataSource.doesFavoriteMealExist(userId, mealId);
    }

    @Override
    public Completable insertPlannerMeal(MealPlanner meal) {
        return localDataSource.insertPlannerMeal(meal);
    }

    @Override
    public Flowable<List<MealPlanner>> getAllCalenderMeals(String userId) {
        return localDataSource.getAllCalenderMeals(userId);
    }

    @Override
    public Completable deletePlannerMeal(MealPlanner meal) {
        return localDataSource.deletePlannerMeal(meal);
    }
}
