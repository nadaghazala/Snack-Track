package com.example.snacktrack.favoritemeal.view.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.example.snacktrack.FavoriteMeal;
import com.example.snacktrack.R;
import com.example.snacktrack.explore.model.Category;
import com.example.snacktrack.explore.view.adapter.CategoriesAdapter;
import com.example.snacktrack.favoritemeal.view.adapter.FavoriteMealAdapter;

public class FavoriteMealViewHolder extends ViewHolder {
    TextView title;

    ImageView picture;

     ImageView deleteBtn;
    public FavoriteMealViewHolder(@NonNull View itemView) {
        super(itemView);
            this.title= itemView.findViewById(R.id.mealTitle);
            this.picture= itemView.findViewById(R.id.mealPic);
            this.deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
        public void bind(FavoriteMeal favoriteMeal, FavoriteMealAdapter.OnItemClickListener listener){

            deleteBtn.setVisibility(View.VISIBLE);
            itemView.setOnClickListener(v -> listener.onItemClick(favoriteMeal.mealID));
            deleteBtn.setOnClickListener(v -> listener.onDeleteClick(favoriteMeal));
            title.setText(favoriteMeal.mealName);
            Glide
                    .with(picture.getContext())
                    .load(favoriteMeal.mealThumbnail)
                    .centerCrop()
                    .into(picture);
        }
    }

