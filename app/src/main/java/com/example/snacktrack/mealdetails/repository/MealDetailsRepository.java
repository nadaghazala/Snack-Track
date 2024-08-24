package com.example.snacktrack.mealdetails.repository;

import com.example.snacktrack.MyRetrofitBuilder;
import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.categorylistexpanded.model.MealsList;
import com.example.snacktrack.explore.model.CategoriesList;
import com.example.snacktrack.explore.presenter.ExploreCallback;
import com.example.snacktrack.explore.repository.CategoriesService;

import com.example.snacktrack.mealdetails.presenter.MealDetailsCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealDetailsRepository {
    MyRetrofitBuilder myRetrofitBuilder;
    MealDetailsService mealDetailsService;

    public MealDetailsRepository() {
        this.myRetrofitBuilder = new MyRetrofitBuilder();
        this.mealDetailsService= myRetrofitBuilder.getRetrofit().create(MealDetailsService.class);
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
}
