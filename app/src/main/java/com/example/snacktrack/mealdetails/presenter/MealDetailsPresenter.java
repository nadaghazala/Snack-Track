package com.example.snacktrack.mealdetails.presenter;

import android.util.Log;

import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.categorylistexpanded.model.Meal;

import com.example.snacktrack.mealdetails.repository.MealDetailsRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MealDetailsPresenter {

    MealDetailsRepository mealDetailsRepository;
    MealDetailsView mealDetailsView;



    public MealDetailsPresenter(MealDetailsView mealDetailsView, MealDetailsRepository mealDetailsRepository) {
        this.mealDetailsRepository = mealDetailsRepository;
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

    public void addToFavorites(FavoriteMeal favoriteMeal){
        mealDetailsRepository.addMealtoFavorites(favoriteMeal).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        ()->{
                            Log.d("nada", "addToFavorites: success");
                        }
                );
    }
}

