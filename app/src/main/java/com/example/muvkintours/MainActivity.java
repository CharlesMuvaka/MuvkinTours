package com.example.muvkintours;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.muvkintours.databinding.ActivityMainBinding;
import com.example.muvkintours.mealApi.Constants;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding mainBind;
    FirebaseAuth myAuth;
    FirebaseAuth.AuthStateListener myAuthListener;
    SharedPreferences myData;
    SharedPreferences.Editor myDataEditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBind.getRoot());

        FirebaseApp.initializeApp(this);
        myAuth = FirebaseAuth.getInstance();
        myData = PreferenceManager.getDefaultSharedPreferences(this);
        myDataEditor = myData.edit();


        mainBind.btnLogin.setOnClickListener(this);
        mainBind.btnSign.setOnClickListener(this);


        createAuthListener();


    }
    public void onCheckBoxClicked(View view){


        mainBind.userName.getEditText().setText(myData.getString(Constants.USEREMAIL, null));
        mainBind.userPhone.getEditText().setText(myData.getString(Constants.USERPASSWORD, null));

    }

    @Override
    public void onClick(View v) {

        if (v == mainBind.btnSign){
            Intent newIntent  = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(newIntent);
        }else{
            login();

        }

    }

    public void login(){
        String email = Objects.requireNonNull(mainBind.userName.getEditText()).getText().toString().trim();
        String password = Objects.requireNonNull(mainBind.userPhone).getEditText().getText().toString().trim();

        Validator validate = new Validator();
        if (!validate.validateName(mainBind.userName) || !validate.validatePassOnly(mainBind.userPhone)){
            return;
        }

        myAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
           if (task.isSuccessful()){
               Toast.makeText(this, "succsessfully logged in", Toast.LENGTH_SHORT).show();
           }else{

               Toast.makeText(MainActivity.this, "User doesn't exist", Toast.LENGTH_SHORT).show();

           }
        });
    }

    public void createAuthListener(){
        myAuthListener = firebaseAuth -> {
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();

            if (currentUser != null){
                Intent newIntent = new Intent(MainActivity.this, MealActivity.class);
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