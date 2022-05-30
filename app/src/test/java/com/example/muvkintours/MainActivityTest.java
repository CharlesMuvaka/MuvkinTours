package com.example.muvkintours;


import android.widget.Button;
import android.widget.TextView;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    MainActivity activity;

    @Before
    public void setUp() throws Exception{
        activity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();

    }

    @Test
    public void checkAppLogo_returnsAppLogo(){

        TextView logo = activity.findViewById(R.id.logo);
        String text = "MuvKinTours";

        assertEquals(text,logo.getText());
    }

    @Test
    public void getOrderButtonText_ReturnsString(){

        Button order = activity.findViewById(R.id.order);
        String text = "Order";

        assertEquals(text, order.getText());
    }
}
