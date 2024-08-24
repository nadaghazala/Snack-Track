package com.example.snacktrack.mealdetails.presenter;

import android.util.Log;

import com.example.snacktrack.categorylistexpanded.model.Meal;

import com.example.snacktrack.mealdetails.repository.MealDetailsRepository;

public class MealDetailsPresenter {

    MealDetailsRepository mealDetailsRepository;
    MealDetailsView mealDetailsView;


    public MealDetailsPresenter(MealDetailsView mealDetailsView) {
        this.mealDetailsRepository = new MealDetailsRepository();
        this.mealDetailsView = mealDetailsView;
    }
    public void getMealDetailsRepository(String id) {

        mealDetailsRepository.getMealDetails(id, new MealDetailsCallback() {
            @Override
            public void onSuccess(Meal meal) {
                mealDetailsView.showMeal(meal);
            }

            @Override
            public void onError(String message) {
                Log.e("MealDetailsPresenter", message);

            }
        });
    }
}

