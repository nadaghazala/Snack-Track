package com.example.snacktrack.explore.repository;

import com.example.snacktrack.MyRetrofitBuilder;
import com.example.snacktrack.explore.model.CategoriesList;

import retrofit2.Call;
import retrofit2.Callback;

public class CategoriesRepository {
    MyRetrofitBuilder myRetrofitBuilder;
    CategoriesService categoriesService;
    public CategoriesRepository(MyRetrofitBuilder myRetrofitBuilder, CategoriesService categoriesService) {
        this.myRetrofitBuilder = new MyRetrofitBuilder();
        this.categoriesService = myRetrofitBuilder.getRetrofit().create(CategoriesService.class);
    }



    public void getCategories(Callback<CategoriesList> callBack) {
        Call<CategoriesList> call = categoriesService.getCategories();
        call.enqueue(callBack);

    }
}


