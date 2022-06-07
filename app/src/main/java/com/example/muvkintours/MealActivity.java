package com.example.muvkintours;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.muvkintours.Adapters.MealRecyclerAdapter;
import com.example.muvkintours.databinding.ActivityMealBinding;
import com.example.muvkintours.mealApi.MealAPi;
import com.example.muvkintours.mealApi.RetrofitClient;
import com.example.muvkintours.models.Category;
import com.example.muvkintours.models.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealActivity extends AppCompatActivity {
    ActivityMealBinding mealBind;
    MealRecyclerAdapter adp;
    RecyclerView.LayoutManager layoutManager;
    List<Category> allCats;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealBind = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(mealBind.getRoot());

        RecyclerView myView = mealBind.recView;

        Intent newIntent = getIntent();
        String name = newIntent.getStringExtra("userName");
        mealBind.mealText.setText("WELCOME"  + name +", click on the category to read more...");

        MealAPi myClient = RetrofitClient.getClient();
        Call<Meal> allMeals = myClient.getCategories();

        allMeals.enqueue(new Callback<Meal>() {
            @Override
            public void onResponse(Call<Meal> call, Response<Meal> response) {

                if (response.isSuccessful()){
                    allCats = response.body().getCategories();

                    adp = new MealRecyclerAdapter(allCats, MealActivity.this);
                    layoutManager = new LinearLayoutManager(MealActivity.this,LinearLayoutManager.VERTICAL, false);
                    myView.setAdapter(adp);
                    myView.setLayoutManager(layoutManager);
                    myView.setHasFixedSize(true);

                    showMeals();
                }else {
                    unSuccessful();
                }
            }

            @Override
            public void onFailure(Call<Meal> call, Throwable t) {
                onReqFailure();

            }
        });




    }

    public void showMeals(){
        mealBind.recView.setVisibility(View.VISIBLE);
        mealBind.mealText.setVisibility(View.VISIBLE);
        mealBind.progressBar.setVisibility(View.GONE);
        mealBind.meal.setVisibility(View.VISIBLE);
    }

    public void unSuccessful(){

        mealBind.mealText.setText("Please check your internet connection");
        mealBind.mealText.setVisibility(View.VISIBLE);
        mealBind.progressBar.setVisibility(View.GONE);
    }

    public void onReqFailure(){
        mealBind.mealText.setText("Something happened try again later");
        mealBind.mealText.setVisibility(View.VISIBLE);
        mealBind.progressBar.setVisibility(View.GONE);
    }
}