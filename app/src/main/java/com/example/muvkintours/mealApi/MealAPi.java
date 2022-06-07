package com.example.muvkintours.mealApi;

import com.example.muvkintours.models.Meal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealAPi {

    @GET("categories.php")
    Call<Meal> getCategories();
}
