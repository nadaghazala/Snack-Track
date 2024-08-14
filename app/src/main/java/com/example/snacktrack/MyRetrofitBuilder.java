package com.example.snacktrack;

import retrofit2.Retrofit;

public class MyRetrofitBuilder {
    private  static MyRetrofitBuilder myRetrofitBuilder= null;
  private  MyRetrofitBuilder (){
  }

    public static MyRetrofitBuilder getMyRetrofitBuilder() {

      if (myRetrofitBuilder ==null)
          myRetrofitBuilder = new MyRetrofitBuilder();
        return myRetrofitBuilder;
    }

    public void getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/")
                .build();
    }
}
