package com.example.snacktrack.categorylistexpanded.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snacktrack.R;
import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.categorylistexpanded.view.viewholder.CategoryListExpandedViewHolder;
import com.example.snacktrack.explore.view.adapter.CategoriesAdapter;

import java.util.ArrayList;

public class CategoryListExpandedAdapter extends RecyclerView.Adapter<CategoryListExpandedViewHolder> {

    private ArrayList<Meal> meals;
    private CategoryListExpandedAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String id);}

    public CategoryListExpandedAdapter(ArrayList<Meal> meals, CategoryListExpandedAdapter.OnItemClickListener listener) {
        this.meals = meals;
        this.listener = listener;

    }




    @NonNull
    @Override
    public CategoryListExpandedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_items, parent, false);
        return new CategoryListExpandedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListExpandedViewHolder holder, int position) {
        holder.bind(meals.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}
