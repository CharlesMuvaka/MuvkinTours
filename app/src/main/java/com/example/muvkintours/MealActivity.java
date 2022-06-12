package com.example.muvkintours;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.muvkintours.Adapters.MealRecyclerAdapter;
import com.example.muvkintours.databinding.ActivityMealBinding;
import com.example.muvkintours.mealApi.Constants;
import com.example.muvkintours.mealApi.MealAPi;
import com.example.muvkintours.mealApi.RetrofitClient;
import com.example.muvkintours.models.Category;
import com.example.muvkintours.models.Meal;
import com.example.muvkintours.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealActivity extends AppCompatActivity {
    ActivityMealBinding mealBind;
    MealRecyclerAdapter adp;
    RecyclerView.LayoutManager layoutManager;
    List<Category> allCats;

    SharedPreferences myData;
    String userName;

    DatabaseReference ref;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealBind = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(mealBind.getRoot());

        myData = PreferenceManager.getDefaultSharedPreferences(this);
        userName = myData.getString(Constants.USERNAME, null);

        mealBind.mealText.setText("WELCOME "  + userName +", click on the category to read more...");



        RecyclerView myView = mealBind.recView;

//        Intent newIntent = getIntent();
//        User currentUser = newIntent.getParcelableExtra("userDetail");
//
//        ref = FirebaseDatabase.getInstance().getReference();
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()){
//                    User savedUser = snapshot.child("0786761610").getValue(User.class);
//
//                    Log.d("TAG", currentUser.getUsername());
//                    Log.d("TAG1", savedUser.getUsername());
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


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