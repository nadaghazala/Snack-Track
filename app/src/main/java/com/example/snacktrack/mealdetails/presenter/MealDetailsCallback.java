package com.example.snacktrack.mealdetails.presenter;

import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.explore.model.CategoriesList;


public interface MealDetailsCallback {
    void onSuccess(Meal meal);
    void onError(String message);
}
