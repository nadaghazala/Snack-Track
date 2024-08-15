package com.example.snacktrack.explore.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snacktrack.R;
import com.example.snacktrack.explore.model.Category;
import com.example.snacktrack.explore.view.viewholder.CategoriesViewHolder;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {

    private ArrayList<Category> categories;
    public CategoriesAdapter(ArrayList<Category> categories) {
        this.categories= categories;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_items, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
    holder.bind(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
