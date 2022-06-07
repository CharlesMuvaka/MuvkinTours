package com.example.muvkintours.mealApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;


    public static MealAPi getClient(){

        if (retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl(Constants.URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit.create(MealAPi.class);
    }
}
