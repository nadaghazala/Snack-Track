package com.example.snacktrack.favoritemeal.presenter;

import android.util.Log;

import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.mealdetails.presenter.MealDetailsCallback;
import com.example.snacktrack.mealdetails.repository.MealDetailsRepository;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavoriteMealPresenter {

    MealDetailsRepository mealDetailsRepository;

    FavoriteMealView favoriteMealView;

    public FavoriteMealPresenter(MealDetailsRepository mealDetailsRepository, FavoriteMealView favoriteMealView) {
        this.mealDetailsRepository = mealDetailsRepository;
        this.favoriteMealView = favoriteMealView;
    }


    public void getFavoriteMeals(String userID){
        mealDetailsRepository.getAllFavouriteMeals(userID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (meals)->{
                            favoriteMealView.showMeal((ArrayList<FavoriteMeal>) meals);
                            Log.d("nada", "addToFavorites: success " + meals.size());
                        }
                );
    }

    public void deleteFavoriteMeals(FavoriteMeal favoriteMeal){
        mealDetailsRepository.deleteFavoriteMeal(favoriteMeal)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        ()->{
                            Log.d("nada", "addToFavorites: success " );
                        }
                );
    }
}
