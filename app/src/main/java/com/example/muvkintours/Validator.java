package com.example.muvkintours;

import android.util.Patterns;

import com.google.android.material.textfield.TextInputLayout;

public class Validator {

    public boolean validateName(TextInputLayout userName){

        if (userName.getEditText().getText().toString().isEmpty()){
            userName.setError("Please Enter your username");
            return false;
        }else{
            userName.setError(null);
            userName.setErrorEnabled(false);
            return true;

        }

    }

    public boolean validatePhone(TextInputLayout userPhone){

        if (userPhone.getEditText().getText().toString().isEmpty()){
            userPhone.setError("Please Enter your mobile Number");
            return false;
        }else if (userPhone.getEditText().getText().toString().length() != 10){
            userPhone.setError("Phone number should be Ten digits");
            return false;
        }
        else{
            userPhone.setError(null);
            userPhone.setErrorEnabled(false);
            return true;

        }


    }

    public boolean validateEmail(TextInputLayout userEmail){

        String email = userEmail.getEditText().getText().toString().trim();

        if (email.isEmpty()){
            userEmail.setError("Please Enter your username");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            userEmail.setError("Please enter a valid email addrress");
            return  false;
        }
        else{
            userEmail.setError(null);
            userEmail.setErrorEnabled(false);
            return true;

        }

    }

    public boolean validatePassword(TextInputLayout pass1, TextInputLayout pass2){

        String pass = pass1.getEditText().getText().toString().trim();
        String password = pass2.getEditText().getText().toString().trim();

        if (pass.isEmpty() ){
            pass1.setError("Please Enter your password");
            return false;
        }else if (password.isEmpty() ){
            pass2.setError("Please confirm your password");
            return false;
        }else if (pass.length() <= 5 ){
            pass1.setError("Password should be more than 5 characters");
            return false;
        }else if (!pass.equals(password)){
            pass2.setError("Passwords should match");
            return  false;
        }
        else{
            pass1.setError(null);
            pass2.setError(null);
            pass1.setErrorEnabled(false);
            pass2.setErrorEnabled(false);
            return true;

        }

    }

    public boolean validatePassOnly(TextInputLayout pass1) {

        String pass = pass1.getEditText().getText().toString().trim();


        if (pass.isEmpty()) {
            pass1.setError("Please Enter your password");
            return false;
        }else{
            pass1.setError(null);
            pass1.setErrorEnabled(false);
            return  true;
        }
    }
}
