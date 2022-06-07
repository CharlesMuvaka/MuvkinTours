package com.example.muvkintours.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.muvkintours.databinding.FragmentMealBinding;
import com.example.muvkintours.models.Category;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;


public class MealFragment extends Fragment {
    FragmentMealBinding mealBinding;
    Category category;




    public MealFragment() {
        // Required empty public constructor
    }


    public static MealFragment newInstance(Category category) {
        MealFragment fragment = new MealFragment();
        Bundle args = new Bundle();
        args.putParcelable("category", Parcels.wrap(category));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = Parcels.unwrap(getArguments().getParcelable("category"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mealBinding = FragmentMealBinding.inflate(inflater, container, false);
        View v = mealBinding.getRoot();

        Picasso.get().load(category.getStrCategoryThumb()).into(mealBinding.image);
        mealBinding.name.setText(category.getStrCategory());
        mealBinding.desc.setText(category.getStrCategoryDescription());
        mealBinding.ingNum.setText("IngredientId: " +category.getIdCategory());

        return v;
    }
}