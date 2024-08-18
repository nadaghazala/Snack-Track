package com.example.snacktrack.categorylistexpanded.view.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.snacktrack.R;
import com.example.snacktrack.categorylistexpanded.model.Meal;
import com.example.snacktrack.categorylistexpanded.view.adapter.CategoryListExpandedAdapter;
import com.example.snacktrack.explore.model.Category;

public class CategoryListExpandedViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView description;

    ImageView picture;
    public CategoryListExpandedViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title= itemView.findViewById(R.id.mealTitle);
        this.picture= itemView.findViewById(R.id.mealPic);
        this.description= itemView.findViewById(R.id.mealDescription);
    }

    public void bind(Meal meal, CategoryListExpandedAdapter.OnItemClickListener listener) {
        itemView.setOnClickListener(v -> listener.onItemClick(meal.idMeal));

        title.setText(meal.strMeal);
        Glide
                .with(picture.getContext())
                .load(meal.strMealThumb)
                .centerCrop()
                .into(picture);
    }
}
