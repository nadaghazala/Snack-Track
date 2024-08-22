package com.example.snacktrack.categorylistexpanded.presenter;

import com.example.snacktrack.categorylistexpanded.model.MealsList;
import com.example.snacktrack.explore.model.CategoriesList;

public interface CategoryListExpandedCallback {
    void onSuccess(MealsList mealsList);
    void onError(String message);
}
