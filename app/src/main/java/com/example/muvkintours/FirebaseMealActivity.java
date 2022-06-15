package com.example.muvkintours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muvkintours.databinding.ActivityMealBinding;
import com.example.muvkintours.mealApi.Constants;
import com.example.muvkintours.models.Meals;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseMealActivity extends AppCompatActivity {
    ActivityMealBinding mealBind;
    RecyclerView recView;
    RecyclerView.LayoutManager manager;
    DatabaseReference ref;
    FirebaseRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealBind = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(mealBind.getRoot());

        recView = mealBind.recView;

        manager = new LinearLayoutManager(FirebaseMealActivity.this, RecyclerView.VERTICAL, false);

        FirebaseApp.initializeApp(this);
        ref = FirebaseDatabase.getInstance().getReference().child(Constants.CATEGORIES);

        FirebaseRecyclerOptions<Meals> options = new FirebaseRecyclerOptions.Builder<Meals>().setQuery(ref, Meals.class).build();

         adapter = new FirebaseRecyclerAdapter<Meals, FirebaseViewHolder>(options) {
            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
                return new FirebaseViewHolder(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder holder, int position, @NonNull Meals model) {
                holder.setdata(model);
            }
        };

         recView.setAdapter(adapter);
         recView.setLayoutManager(manager);
         recView.setHasFixedSize(true);
         recView.setVisibility(View.VISIBLE);
         mealBind.progressBar.setVisibility(View.GONE);
         mealBind.showSavedMeals.setVisibility(View.GONE);
         mealBind.meal.setText("Below is a list of the saved Meals ");
         mealBind.meal.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.startListening();
    }
}