package com.example.snacktrack.favoritemeal.presenter;

import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.categorylistexpanded.model.Meal;

import java.util.ArrayList;

public interface FavoriteMealView {
    void showMeal(ArrayList<FavoriteMeal> meals);
}
