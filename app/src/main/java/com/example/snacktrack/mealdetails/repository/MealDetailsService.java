package com.example.snacktrack.mealdetails.repository;

import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.categorylistexpanded.model.MealsList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealDetailsService {

    @GET("lookup.php")
    public Call<MealsList> getMealDetails(@Query("i") String id);
}

