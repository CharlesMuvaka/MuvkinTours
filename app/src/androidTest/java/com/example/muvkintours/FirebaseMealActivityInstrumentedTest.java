package com.example.muvkintours;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FirebaseMealActivityInstrumentedTest {

    @Rule
    public ActivityScenarioRule<FirebaseMealActivity> fireRule = new ActivityScenarioRule<>(FirebaseMealActivity.class);

    @Test
    public void checkTextViewVisibility() {
        onView(withId(R.id.mealText)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.meal)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void checkRecyclerViewVisibility() {
        onView(withId(R.id.recView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

    }

    @Test
    public void checkProgressBarVisibility() {

        onView(withId(R.id.progressBar)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));

    }

    @Test
    public void checkButtonVisibility() {

        onView(withId(R.id.showSavedMeals)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));

    }

}
