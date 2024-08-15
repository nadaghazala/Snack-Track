package com.example.snacktrack.explore.presenter;

import com.example.snacktrack.explore.model.CategoriesList;

public interface ExploreCallback {
    void onSuccess(CategoriesList categoriesList);
    void onError(String message);

}
