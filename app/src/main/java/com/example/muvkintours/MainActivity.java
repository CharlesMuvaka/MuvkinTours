package com.example.muvkintours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.muvkintours.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mainBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBind.getRoot());

        mainBind.order.setOnClickListener(this);
        mainBind.img1.setOnClickListener(this);
        mainBind.foodImg2.setOnClickListener(this);
        mainBind.foodImg3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mainBind.order){
            Intent signIntent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(signIntent);
        }

        if (v == mainBind.img1 || v == mainBind.foodImg2 || v == mainBind.foodImg3){

            Toast.makeText(MainActivity.this, "Click on the order button to submit delivery details", Toast.LENGTH_LONG).show();
        }
    }
}