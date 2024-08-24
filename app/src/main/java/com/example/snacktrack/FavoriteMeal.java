package com.example.snacktrack;

import androidx.room.Entity;

@Entity
public class FavoriteMeal {
    String userID;
    String mealID;
    String mealName;
    String mealThumbnail;
}
