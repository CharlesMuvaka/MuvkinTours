package com.example.muvkintours;

import static org.junit.Assert.*;

import com.google.android.material.textfield.TextInputLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class SignUpActivityTest {
    SignUpActivity activity;

    @Before
    public void setUp() throws Exception {

        activity = Robolectric.buildActivity(SignUpActivity.class).create().start().resume().get();

    }

    @Test
    public void getHint_Returns_true(){

        TextInputLayout user = activity.findViewById(R.id.userName);

        assertEquals("Enter you full name", user.getEditText().getHint());
    }
}