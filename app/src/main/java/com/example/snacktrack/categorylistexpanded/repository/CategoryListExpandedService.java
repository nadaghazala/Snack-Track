package com.example.snacktrack.categorylistexpanded.repository;

import com.example.snacktrack.categorylistexpanded.model.MealsList;
import com.example.snacktrack.explore.model.CategoriesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryListExpandedService {
    @GET("filter.php")
    public Call<MealsList> getMealsByCategory( @Query("c") String category);

}
