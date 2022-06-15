package com.example.muvkintours.mealApi;

import com.example.muvkintours.models.Food;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealAPi {

    @GET("search.php")
    Call<Food> getCategories(
            @Query("f") String letter
    );

    @GET("search.php")
    Call<Food> getMeals(
            @Query("f") String letter
    );
}
