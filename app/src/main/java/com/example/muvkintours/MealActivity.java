package com.example.muvkintours;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muvkintours.Adapters.MealRecyclerAdapter;
import com.example.muvkintours.databinding.ActivityMealBinding;
import com.example.muvkintours.mealApi.Constants;
import com.example.muvkintours.mealApi.MealAPi;
import com.example.muvkintours.mealApi.RetrofitClient;
import com.example.muvkintours.models.Food;
import com.example.muvkintours.models.Meals;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealActivity extends AppCompatActivity implements  View.OnClickListener{

    ActivityMealBinding mealBind;
    MealRecyclerAdapter adp;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MealActivity.this,LinearLayoutManager.VERTICAL, false);
    List<Meals> allCats;
    SharedPreferences myData;
    SharedPreferences.Editor myDataEditor;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealBind = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(mealBind.getRoot());

        //SharedPreferences variables
        myData = PreferenceManager.getDefaultSharedPreferences(this);
        userName = myData.getString(Constants.USERNAME, null);
        myDataEditor = myData.edit();

        mealBind.mealText.setText("WELCOME, "  + userName);
        RecyclerView myView = mealBind.recView;
        MaterialButton cart = mealBind.showSavedMeals;
        cart.setOnClickListener(this);


        MealAPi myClient = RetrofitClient.getClient();
        Call<Food> allMeals = myClient.getCategories("b");

        allMeals.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {

                if (response.isSuccessful()){
                    allCats = response.body().getMeals();

                    adp = new MealRecyclerAdapter(allCats, MealActivity.this);

                    myView.setAdapter(adp);
                    myView.setLayoutManager(layoutManager);
                    myView.setHasFixedSize(true);

                    showMeals();
                }else {
                    unSuccessful();
                }
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {
                onReqFailure();

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        myData = PreferenceManager.getDefaultSharedPreferences(this);
        myDataEditor = myData.edit();

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        MenuItem item = menu.findItem(R.id.search);
        SearchView userSearch = (SearchView) item.getActionView();
        userSearch.setBackgroundColor(Color.BLACK);
        userSearch.setQueryHint("Enter first letter of meal");

        userSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 1){
                    mealBind.meal.setTextColor(Color.RED);
                    mealBind.meal.setText("Your input should be a single character");

                }
                addToPreferenceShares(query);

                Log.d("TAG", query);

                MealAPi myClient = RetrofitClient.getClient();
                Call<Food> getMeals = myClient.getMeals(query);
                getMeals.enqueue(new Callback<Food>() {
                    @Override
                    public void onResponse(Call<Food> call, Response<Food> response) {
                        if (response.isSuccessful()){
                            allCats = response.body().getMeals();

                            if (allCats != null){
                                adp = new MealRecyclerAdapter(allCats, MealActivity.this);
                                mealBind.recView.setAdapter(adp);
                                mealBind.recView.setLayoutManager(layoutManager);
                                mealBind.recView.setHasFixedSize(true);
                                showMeals();
                            }else{
                                unSuccessful();
                            }

                        }else {
                            unSuccessful();
                        }
                    }

                    @Override
                    public void onFailure(Call<Food> call, Throwable t) {
                        onReqFailure();

                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout){
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addToPreferenceShares(String wordToStore){
        myDataEditor.putString("userLetter", wordToStore).apply();

    }

    public void showMeals(){
        mealBind.recView.setVisibility(View.VISIBLE);
        mealBind.mealText.setVisibility(View.VISIBLE);
        mealBind.progressBar.setVisibility(View.GONE);
        mealBind.meal.setVisibility(View.VISIBLE);
        mealBind.showSavedMeals.setVisibility(View.VISIBLE);
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

    @Override
    public void onClick(View v) {
        Intent newIntent = new Intent(MealActivity.this, FirebaseMealActivity.class);
        startActivity(newIntent);
    }

    public void logout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MealActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}