package com.example.muvkintours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.muvkintours.databinding.ActivitySignUpBinding;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySignUpBinding signBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signBind = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(signBind.getRoot());

        signBind.btnSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == signBind.btnSubmit){

            Validator validate = new Validator();
            TextInputLayout userName = signBind.userName;
            TextInputLayout userPhone = signBind.userPhone;

           if (!validate.validateName(userName) || !validate.validatePhone(userPhone)){
               return;
           }else{
               String name = userName.getEditText().getText().toString();
               Intent meals = new Intent(SignUpActivity.this, MealActivity.class);
               meals.putExtra("name", name);
               Toast.makeText(SignUpActivity.this, "Details received Successfully", Toast.LENGTH_SHORT).show();
               startActivity(meals);
           }
        }

    }


}