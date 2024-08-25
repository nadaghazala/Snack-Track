package com.example.snacktrack.favoritemeal.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.R;
import com.example.snacktrack.explore.model.Category;
import com.example.snacktrack.explore.view.adapter.CategoriesAdapter;
import com.example.snacktrack.explore.view.viewholder.CategoriesViewHolder;
import com.example.snacktrack.favoritemeal.view.viewholder.FavoriteMealViewHolder;

import java.util.ArrayList;

public class FavoriteMealAdapter extends RecyclerView.Adapter<FavoriteMealViewHolder> {
    private ArrayList<FavoriteMeal> favoriteMeals;
    private FavoriteMealAdapter.OnItemClickListener listener;



    public interface OnItemClickListener {
        void onItemClick(String favoriteMeals);
        void onDeleteClick(FavoriteMeal favoriteMeal);
    }

    public void setFavoriteMeals(ArrayList<FavoriteMeal> favoriteMeals){
        this.favoriteMeals=favoriteMeals;
        notifyDataSetChanged();
    }

    public FavoriteMealAdapter(ArrayList<FavoriteMeal> favoriteMeals, OnItemClickListener listener) {
        this.favoriteMeals = favoriteMeals;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FavoriteMealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_items, parent, false);
        return new FavoriteMealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteMealViewHolder holder, int position) {
        holder.bind(favoriteMeals.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return favoriteMeals.size();
    }


}
