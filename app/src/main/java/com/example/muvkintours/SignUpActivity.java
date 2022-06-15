package com.example.muvkintours;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.muvkintours.databinding.ActivitySignUpBinding;
import com.example.muvkintours.mealApi.Constants;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySignUpBinding signBind;
    FirebaseAuth myAuth;
    FirebaseAuth.AuthStateListener myAuthListener;
    SharedPreferences myData;
    SharedPreferences.Editor myDataEditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signBind = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(signBind.getRoot());

        myData = PreferenceManager.getDefaultSharedPreferences(this);
        myDataEditor = myData.edit();

        signBind.btnSubmit.setOnClickListener(this);

        FirebaseApp.initializeApp(this);
        myAuth = FirebaseAuth.getInstance();
        createAuthListener();

    }

    @Override
    public void onClick(View v) {
        if (v == signBind.btnSubmit){
            createUser();
        }
    }

    public void createUser(){

        String email = Objects.requireNonNull(signBind.userTicket.getEditText()).getText().toString().trim();
        String password = Objects.requireNonNull(signBind.userSeat.getEditText()).getText().toString().trim();
        String name = Objects.requireNonNull(signBind.userName.getEditText()).getText().toString().trim();
        String phone = Objects.requireNonNull(signBind.userPhone.getEditText()).getText().toString().trim();

        Validator validate = new Validator();

        if (!validate.validateEmail(signBind.userTicket) || !validate.validatePassword(signBind.userSeat, signBind.userCoach) || !validate.validateName(signBind.userName) || !validate.validatePhone(signBind.userPhone)){
            return;
        }

        myDataEditor.putString(Constants.USERNAME, name).apply();
        myDataEditor.putString(Constants.USERPHONE, phone).apply();
        myDataEditor.putString(Constants.USERPASSWORD, password).apply();
        myDataEditor.putString(Constants.USEREMAIL, email).apply();



        myAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()){
                Toast.makeText(this, "User Created successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "User not created", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void createAuthListener(){
        myAuthListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();

            if (user != null){

                Intent newIntent = new Intent(SignUpActivity.this, MealActivity.class);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(newIntent);
                finish();
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAuth.addAuthStateListener(myAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAuth.removeAuthStateListener(myAuthListener);
    }
}