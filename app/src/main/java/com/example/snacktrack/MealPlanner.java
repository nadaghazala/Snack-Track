package com.example.snacktrack;

import androidx.annotation.NonNull;
import androidx.room.Entity;
@Entity(primaryKeys = {"userID","mealID","day"})

public class MealPlanner {

        @NonNull
        public String userID;
        @NonNull
        public String mealID;
        public String mealName;
        public String mealThumbnail;
        @NonNull
        public String day;
}


