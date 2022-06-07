package com.example.muvkintours;

import static org.junit.Assert.*;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MealActivityTest {
    MealActivity act;

    @Before
    public void setUp() {
        act = Robolectric.buildActivity(MealActivity.class).create().start().resume().get();
    }

    @Test
    public void getParagraphText_ReturnsString(){

        TextView order = act.findViewById(R.id.mealText);
        String text = "WELCOMEnull, click on the category to read more...";

        assertEquals(text, order.getText());
    }


}