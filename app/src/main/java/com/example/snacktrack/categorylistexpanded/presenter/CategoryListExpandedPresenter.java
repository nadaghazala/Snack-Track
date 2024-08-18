package com.example.snacktrack.categorylistexpanded.presenter;

import android.util.Log;

import com.example.snacktrack.categorylistexpanded.model.MealsList;
import com.example.snacktrack.categorylistexpanded.repository.CategoryListExpandedRepository;
import com.example.snacktrack.explore.model.CategoriesList;
import com.example.snacktrack.explore.presenter.ExploreCallback;
import com.example.snacktrack.explore.presenter.ExploreView;
import com.example.snacktrack.explore.repository.CategoriesRepository;

public class CategoryListExpandedPresenter {

    CategoryListExpandedRepository categoryListExpandedRepository;
    CategoryListExpandedView categoryListExpandedView;

    public CategoryListExpandedPresenter(CategoryListExpandedView categoryListExpandedView) {
        this.categoryListExpandedRepository = new CategoryListExpandedRepository();
        this.categoryListExpandedView = categoryListExpandedView;

    }

    public void getCategoryListExpandedRepository(String category){

        categoryListExpandedRepository.getMealsByCategory(category, new CategoryListExpandedCallback() {
            @Override
            public void onSuccess(MealsList mealsList) {
                categoryListExpandedView.showMealsByCategory(mealsList.meals);
            }

            @Override
            public void onError(String message) {
                Log.e("ExplorePresenter", message);

            }
        });
    }


}
