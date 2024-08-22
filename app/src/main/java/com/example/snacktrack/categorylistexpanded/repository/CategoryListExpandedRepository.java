package com.example.snacktrack.categorylistexpanded.repository;

import com.example.snacktrack.MyRetrofitBuilder;
import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.categorylistexpanded.model.MealsList;
import com.example.snacktrack.categorylistexpanded.presenter.CategoryListExpandedCallback;
import com.example.snacktrack.explore.model.CategoriesList;
import com.example.snacktrack.explore.presenter.ExploreCallback;
import com.example.snacktrack.explore.repository.CategoriesService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryListExpandedRepository {

    MyRetrofitBuilder myRetrofitBuilder;
    CategoryListExpandedService categoryListExpandedService;

    public CategoryListExpandedRepository() {
        this.myRetrofitBuilder = new MyRetrofitBuilder();
        this.categoryListExpandedService = myRetrofitBuilder.getRetrofit().create(CategoryListExpandedService.class);
    }

    public void getMealsByCategory (String category, CategoryListExpandedCallback callback){
        Call<MealsList> call = categoryListExpandedService.getMealsByCategory(category);
        call.enqueue(new Callback<MealsList>() {
            @Override
            public void onResponse(Call<MealsList> call, Response<MealsList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
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
