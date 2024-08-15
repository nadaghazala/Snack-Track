package com.example.snacktrack;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MyRetrofitBuilder {
    private  static MyRetrofitBuilder myRetrofitBuilder= null;
  public MyRetrofitBuilder(){
  }

    public static MyRetrofitBuilder getMyRetrofitBuilder() {

      if (myRetrofitBuilder ==null)
          myRetrofitBuilder = new MyRetrofitBuilder();
        return myRetrofitBuilder;
    }

    public Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
