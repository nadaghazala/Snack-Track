package com.example.snacktrack.categorylistexpanded.model;

import com.example.snacktrack.explore.model.Category;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MealsList {
    @SerializedName("meals")
    public ArrayList<Meal> meals;
}
