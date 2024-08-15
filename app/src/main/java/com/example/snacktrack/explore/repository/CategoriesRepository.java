package com.example.snacktrack.explore.repository;

import com.example.snacktrack.MyRetrofitBuilder;
import com.example.snacktrack.explore.model.CategoriesList;
import com.example.snacktrack.explore.presenter.ExploreCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesRepository {
    MyRetrofitBuilder myRetrofitBuilder;
    CategoriesService categoriesService;

    public CategoriesRepository() {
        this.myRetrofitBuilder = new MyRetrofitBuilder();
        this.categoriesService = myRetrofitBuilder.getRetrofit().create(CategoriesService.class);
    }


    public void getCategories(final ExploreCallback callback) {
        Call<CategoriesList> call = categoriesService.getCategories();
        call.enqueue(new Callback<CategoriesList>() {
            @Override
            public void onResponse(Call<CategoriesList> call, Response<CategoriesList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CategoriesList> call, Throwable throwable) {
                callback.onError("Error: " + throwable.getMessage());
            }
        });

    }
}


