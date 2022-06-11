package com.example.muvkintours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.muvkintours.databinding.ActivityMainBinding;
import com.example.muvkintours.mealApi.Constants;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mainBind;
    private FirebaseDatabase muvkin;
    private DatabaseReference ref;
    private SharedPreferences store;
    private SharedPreferences.Editor storeEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBind.getRoot());

        muvkin = FirebaseDatabase.getInstance();
        ref = muvkin.getReference();

        mainBind.btnLogin.setOnClickListener(this);
        mainBind.btnSign.setOnClickListener(this);

        store = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        storeEditor = store.edit();


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
//            mealIntent.putExtra("userName", userName.getEditText().getText().toString());
            storeEditor.putString(Constants.USERNAME,userName.getEditText().getText().toString()).apply();
            Log.d("TAG", Constants.USERNAME.toString() );
            startActivity(mealIntent);

        }else{

            Intent signIntent = new Intent(MainActivity.this, SignUpActivity.class );
            startActivity(signIntent);
        }

    }
}