package com.example.snacktrack.favoritemeal.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.R;
import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.database.DatabaseHandler;
import com.example.snacktrack.favoritemeal.presenter.FavoriteMealPresenter;
import com.example.snacktrack.favoritemeal.presenter.FavoriteMealView;
import com.example.snacktrack.favoritemeal.view.adapter.FavoriteMealAdapter;
import com.example.snacktrack.mealdetails.repository.MealDetailsRepository;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class FavoriteFragment extends Fragment implements FavoriteMealView , FavoriteMealAdapter.OnItemClickListener {

FavoriteMealPresenter favoriteMealPresenter;
FavoriteMealAdapter favoriteMealAdapter;
RecyclerView recyclerView;

    public FavoriteFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favoriteMealAdapter= new FavoriteMealAdapter(new ArrayList<>(),this);
        recyclerView = view.findViewById(R.id.recyclerViewFavoriteMeal);
        recyclerView.setAdapter(favoriteMealAdapter);
        favoriteMealPresenter= new FavoriteMealPresenter(new MealDetailsRepository(new DatabaseHandler(getContext())),this);
        if (FirebaseAuth.getInstance().getCurrentUser()!=null) {
            favoriteMealPresenter.getFavoriteMeals(FirebaseAuth.getInstance().getUid());
        }
    }

    @Override
    public void showMeal(ArrayList<FavoriteMeal> meals) {
        favoriteMealAdapter.setFavoriteMeals(meals);
    }

    @Override
    public void onItemClick(String favoriteMeals) {

    }

    @Override
    public void onDeleteClick(FavoriteMeal favoriteMeal) {
        favoriteMealPresenter.deleteFavoriteMeals(favoriteMeal);
    }
}