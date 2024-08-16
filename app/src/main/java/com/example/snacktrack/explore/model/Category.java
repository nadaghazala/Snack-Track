package com.example.snacktrack.explore.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Category{
    @SerializedName("idCategory")

    public String idCategory;
    @SerializedName("strCategory")
    public String strCategory;
    @SerializedName("strCategoryThumb")
    public String strCategoryThumb;
    @SerializedName("strCategoryDescription")
    public String strCategoryDescription;
}

