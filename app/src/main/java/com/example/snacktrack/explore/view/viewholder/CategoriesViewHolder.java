package com.example.snacktrack.explore.view.viewholder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.snacktrack.R;
import com.example.snacktrack.explore.model.Category;
import com.example.snacktrack.explore.view.adapter.CategoriesAdapter;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {
    TextView title;

    ImageView picture;

    public CategoriesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title= itemView.findViewById(R.id.categoryTitle);
        this.picture= itemView.findViewById(R.id.categoryPic);

    }
    public void bind(Category category, CategoriesAdapter.OnItemClickListener listener){
        itemView.setOnClickListener(v -> listener.onItemClick(category.strCategory));
        title.setText(category.strCategory);
        Glide
                .with(picture.getContext())
                .load(category.strCategoryThumb)
                .centerCrop()
                .into(picture);
    }
}
