package com.example.muvkintours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.muvkintours.databinding.ActivitySignUpBinding;
import com.example.muvkintours.models.User;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySignUpBinding signBind;
    private DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signBind = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(signBind.getRoot());

        ref = FirebaseDatabase.getInstance().getReference();

        signBind.btnSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == signBind.btnSubmit){

            Validator validate = new Validator();
            TextInputLayout userName = signBind.userName;
            TextInputLayout userPhone = signBind.userPhone;
            TextInputLayout userSeat = signBind.userSeat;
            TextInputLayout userTicket = signBind.userTicket;
            TextInputLayout userCoach = signBind.userCoach;


           if (!validate.validateName(userName) || !validate.validatePhone(userPhone) || !validate.validateName(userSeat) || !validate.validateName(userTicket) || !validate.validateName(userCoach)){
               return;
           }else{

               String name = userName.getEditText().getText().toString();
               String phone = userPhone.getEditText().getText().toString();
               String seat = userSeat.getEditText().getText().toString();
               String ticket = userTicket.getEditText().getText().toString();
               String coach = userCoach.getEditText().getText().toString();

               User newUser = new User(name, phone, ticket, seat, coach);

               ref.child(phone).setValue(newUser);

               Intent meals = new Intent(SignUpActivity.this, MealActivity.class);
               meals.putExtra("userDetails", Parcels.wrap(newUser));
               Toast.makeText(SignUpActivity.this, "Details received Successfully", Toast.LENGTH_SHORT).show();
               startActivity(meals);
           }
        }

    }


}