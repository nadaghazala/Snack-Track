package com.example.snacktrack.mealdetails.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.snacktrack.R;
import com.example.snacktrack.categorylistexpanded.model.Meal;

import com.example.snacktrack.mealdetails.presenter.MealDetailsPresenter;
import com.example.snacktrack.mealdetails.presenter.MealDetailsView;

public class MealDetailsFragment extends Fragment implements MealDetailsView {

    MealDetailsPresenter mealDetailsPresenter ;
    RecyclerView recyclerView;
    ImageView imageView;
    TextView title;
    TextView originCountry;
    TextView description;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_details, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String id = getArguments().getString("mealId");
        recyclerView= view.findViewById(R.id.recyclerView);
        mealDetailsPresenter= new MealDetailsPresenter(this);
        mealDetailsPresenter.getMealDetailsRepository(id);
        imageView= view.findViewById(R.id.mealPicInDetails);
        title= view.findViewById(R.id.mealTitleInDetails);
        originCountry= view.findViewById(R.id.originCountryText);
        description= view.findViewById(R.id.mealDescriptionInDetails);
    }


    @Override
    public void showMeal(Meal meal) {
        title.setText(meal.strMeal);
        description.setText(meal.strInstructions);
        originCountry.setText(meal.strArea);
        Glide
                .with(imageView.getContext())
                .load(meal.strMealThumb)
                .centerCrop()
                .into(imageView);

    }
}
