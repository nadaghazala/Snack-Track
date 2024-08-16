package com.example.snacktrack.explore.presenter;

import android.util.Log;

import com.example.snacktrack.explore.model.CategoriesList;
import com.example.snacktrack.explore.repository.CategoriesRepository;

public class ExplorePresenter {
    CategoriesRepository categoriesRepository;
    ExploreView exploreView;

    public ExplorePresenter(ExploreView exploreView) {
        this.categoriesRepository = new CategoriesRepository();
        this.exploreView = exploreView;

    }

    public void getCategoriesRepository() {

        categoriesRepository.getCategories(new ExploreCallback() {
            @Override
            public void onSuccess(CategoriesList categoriesList) {
                exploreView.showCategoriesList(categoriesList);
            }

            @Override
            public void onError(String message) {
                Log.e("ExplorePresenter", message);

            }
        });
    }


}
