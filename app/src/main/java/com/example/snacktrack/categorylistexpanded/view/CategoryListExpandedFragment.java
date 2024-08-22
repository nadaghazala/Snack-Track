package com.example.snacktrack.categorylistexpanded.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snacktrack.R;
import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.categorylistexpanded.model.MealsList;
import com.example.snacktrack.categorylistexpanded.presenter.CategoryListExpandedPresenter;
import com.example.snacktrack.categorylistexpanded.presenter.CategoryListExpandedView;
import com.example.snacktrack.categorylistexpanded.view.adapter.CategoryListExpandedAdapter;
import com.example.snacktrack.explore.model.CategoriesList;
import com.example.snacktrack.explore.view.ExploreFragmentDirections;
import com.example.snacktrack.explore.view.adapter.CategoriesAdapter;

import java.util.ArrayList;


public class CategoryListExpandedFragment extends Fragment implements CategoryListExpandedView {
CategoryListExpandedPresenter categoryListExpandedPresenter;
RecyclerView recyclerView;
TextView textView;
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_category_list_expanded, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String category = getArguments().getString("category");
        // String meal = getArguments().getString("meal");

        textView= view.findViewById(R.id.categoryTitle);
        recyclerView= view.findViewById(R.id.recyclerViewCateogryExpanded);
        categoryListExpandedPresenter = new CategoryListExpandedPresenter(this);
        categoryListExpandedPresenter.getCategoryListExpandedRepository(category);
    }


    @Override
    public void showMealsByCategory(ArrayList<Meal> meals) {
        CategoryListExpandedAdapter categoryListExpandedAdapter= new CategoryListExpandedAdapter(meals, id->{
            NavHostFragment.findNavController(this).navigate(CategoryListExpandedFragmentDirections.categoryListExpandedToMealDetailsFragment(id));
        });
        recyclerView.setAdapter(categoryListExpandedAdapter);
    }
}