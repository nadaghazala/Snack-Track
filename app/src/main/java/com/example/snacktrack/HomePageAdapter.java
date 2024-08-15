package com.example.snacktrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.HomePageViewHolder> {

    Context context;
    ArrayList<Meals> mealsArrayList;

    public HomePageAdapter(Context context, ArrayList<Meals> mealsArrayList) {
        this.context = context;
        this.mealsArrayList = mealsArrayList;
    }

    @NonNull
    @Override
    public HomePageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.listitems, parent, false);

        return new HomePageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageViewHolder holder, int position) {
        ArrayList<Meals> meals= mealsArrayList;
        holder.mealTitleTxt.setText(meals.get(position).mealTitleTxt);
       // holder.imageView.setImageResource(meals.imageView);
    }

    @Override
    public int getItemCount() {
        return mealsArrayList.size();
    }

    public static class HomePageViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView mealTitleTxt;
        ImageButton addToFavorites;
        Button addToPlanner;

        public HomePageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.mealPic);
            mealTitleTxt= itemView.findViewById(R.id.mealTitle);
            addToFavorites= itemView.findViewById(R.id.favBtn);
            addToPlanner= itemView.findViewById(R.id.addToPlannerBtn);

        }
    }

}
