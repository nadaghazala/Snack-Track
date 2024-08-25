
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.R;
import com.example.snacktrack.categorylistexpanded.model.Meal;

import com.example.snacktrack.database.DatabaseHandler;
import com.example.snacktrack.mealdetails.presenter.MealDetailsPresenter;
import com.example.snacktrack.mealdetails.presenter.MealDetailsView;
import com.example.snacktrack.mealdetails.repository.MealDetailsRepository;
import com.google.firebase.auth.FirebaseAuth;

public class MealDetailsFragment extends Fragment implements MealDetailsView {

    MealDetailsPresenter mealDetailsPresenter ;
    RecyclerView recyclerView;
    ImageView imageView;
    TextView title;
    TextView originCountry;
    TextView description;
    ImageView addToFavsBtn;

    Meal currentMeal;


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
        mealDetailsPresenter= new MealDetailsPresenter(this,new MealDetailsRepository(new DatabaseHandler(getContext())));
        mealDetailsPresenter.getMealDetailsRepository(id);
        imageView= view.findViewById(R.id.mealPicInDetails);
        title= view.findViewById(R.id.mealTitleInDetails);
        originCountry= view.findViewById(R.id.originCountryText);
        description= view.findViewById(R.id.mealDescriptionInDetails);
        addToFavsBtn= view.findViewById(R.id.addToFavorites);

        addToFavsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FirebaseAuth.getInstance().getCurrentUser() !=null)
                {
                    Toast.makeText(getContext(), "added", Toast.LENGTH_SHORT).show();
                    FavoriteMeal favoriteMeal= new FavoriteMeal();
                    favoriteMeal.mealID = id;
                    favoriteMeal.mealName= currentMeal.strMeal;
                    favoriteMeal.mealThumbnail= currentMeal.strMealThumb;
                    favoriteMeal.userID= FirebaseAuth.getInstance().getUid();
                    mealDetailsPresenter.addToFavorites(favoriteMeal);
                }

            }
        });
    }


    @Override
    public void showMeal(Meal meal) {
        currentMeal=meal;
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
