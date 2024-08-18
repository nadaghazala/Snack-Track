package com.example.snacktrack.categorylistexpanded.presenter;

import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.categorylistexpanded.model.MealsList;

import java.util.ArrayList;

public interface CategoryListExpandedView {
   public void showMealsByCategory(ArrayList<Meal> meals);
}
