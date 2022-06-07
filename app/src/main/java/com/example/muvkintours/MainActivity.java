package com.example.muvkintours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.muvkintours.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mainBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBind.getRoot());

        mainBind.btnLogin.setOnClickListener(this);
        mainBind.btnSign.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        Validator validator = new Validator();
        TextInputLayout userName = mainBind.userName;
        TextInputLayout userPhone = mainBind.userPhone;

        if (v == mainBind.btnLogin ){
            if(!validator.validateName(userName) || !validator.validatePhone(userPhone)){
                return;
            }

            Intent mealIntent = new Intent(MainActivity.this, MealActivity.class );
            mealIntent.putExtra("userName", userName.getEditText().getText().toString());
            startActivity(mealIntent);

        }else{

            Intent signIntent = new Intent(MainActivity.this, SignUpActivity.class );
            startActivity(signIntent);
        }

    }
}