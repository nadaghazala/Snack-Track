package com.example.snacktrack;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"userID","mealID"})
public class FavoriteMeal {
    @NonNull
   public String userID;
    @NonNull
    public String mealID;
    public String mealName;
    public String mealThumbnail;
}
