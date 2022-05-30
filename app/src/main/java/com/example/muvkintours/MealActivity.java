package com.example.muvkintours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.muvkintours.Adapters.GridAdapter;
import com.example.muvkintours.databinding.ActivityMealBinding;

public class MealActivity extends AppCompatActivity {
    ActivityMealBinding mealBind;
     String[] meals = new String[]{
             "Pilau",
             "Rice",
             "Githeri",
             "beer",
             "juice",
             "Guavas",
             "Ugali",
             "Burger",
             "Samosa",
             "Samosa",
             "Samosa",
             "Samosa",
             "Samosa",
             "Samosa"
     };

     int[] images = new int[]{
             R.drawable.pilau,
             R.drawable.rice,
             R.drawable.githeri,
             R.drawable.beer,
             R.drawable.githeri,
             R.drawable.fruits,
             R.drawable.ugali,
             R.drawable.rice,
             R.drawable.samosa,
             R.drawable.samosa,
             R.drawable.samosa,
             R.drawable.samosa,
             R.drawable.samosa,
             R.drawable.samosa

     };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealBind = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(mealBind.getRoot());

        Intent newIntent = getIntent();
        String name = newIntent.getStringExtra("name");
        mealBind.mealText.setText("Welcome to the list of our available meals " + name);


        GridAdapter adp = new GridAdapter(MealActivity.this,meals ,images);
        mealBind.grid.setAdapter(adp);

        mealBind.grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MealActivity.this, name + "its not done wait!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}