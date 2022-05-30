package com.example.muvkintours;

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
}
