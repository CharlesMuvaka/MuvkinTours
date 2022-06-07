package com.example.muvkintours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;

import com.example.muvkintours.Adapters.MealPagerAdapter;
import com.example.muvkintours.databinding.ActivityMealDetailBinding;
import com.example.muvkintours.models.Category;

import org.parceler.Parcels;

import java.util.List;

public class MealDetailActivity extends AppCompatActivity {
    ActivityMealDetailBinding detBind;
    MealPagerAdapter adp;
    List<Category> allCats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detBind = ActivityMealDetailBinding.inflate(getLayoutInflater());
        setContentView(detBind.getRoot());

        int position = getIntent().getIntExtra("position", 0);
        allCats = Parcels.unwrap(getIntent().getParcelableExtra("cats"));
        adp = new MealPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, allCats );
        detBind.viewPager.setAdapter(adp);
        detBind.viewPager.setCurrentItem(position);
    }
}