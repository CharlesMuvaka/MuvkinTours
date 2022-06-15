package com.example.muvkintours.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.muvkintours.fragments.MealFragment;
import com.example.muvkintours.models.Meals;

import java.util.List;

public class MealPagerAdapter extends FragmentPagerAdapter {

    private List<Meals> allCats;

    public MealPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Meals> cats ) {
        super(fm, behavior);

        this.allCats = cats;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        MealFragment frag = MealFragment.newInstance(allCats.get(position));

        return frag;
    }

    @Override
    public int getCount() {
        return allCats.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return allCats.get(position).getStrMeal();
    }
}
