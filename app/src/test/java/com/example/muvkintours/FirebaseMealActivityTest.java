package com.example.muvkintours;

import static org.junit.Assert.*;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class FirebaseMealActivityTest {
    FirebaseMealActivity activity;

    @Before
    public void setUp() throws Exception {

        activity = Robolectric.buildActivity(FirebaseMealActivity.class).create().start().resume().get();
    }

    @Test
    public void checkWelcomeText(){
        TextView welcome = activity.findViewById(R.id.meal);
        String text = "Below is a list of the saved Meals ";

        assertEquals(text, welcome.getText());
    }
}