package com.example.snacktrack.explore.repository;

import com.example.snacktrack.explore.model.CategoriesList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriesService {
@GET("categories.php")
public Call<CategoriesList> getCategories();
}
