package com.example.muvkintours.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.muvkintours.databinding.FragmentMealBinding;
import com.example.muvkintours.mealApi.Constants;
import com.example.muvkintours.models.Meals;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class MealFragment extends Fragment {
    FragmentMealBinding mealBinding;
    Meals category;




    public MealFragment() {
        // Required empty public constructor
    }


    public static MealFragment newInstance(Meals category) {
        MealFragment fragment = new MealFragment();
        Bundle args = new Bundle();
        args.putSerializable("category", category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = (Meals) getArguments().getSerializable("category");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mealBinding = FragmentMealBinding.inflate(inflater, container, false);
        View v = mealBinding.getRoot();

        Picasso.get().load(category.getStrMealThumb()).into(mealBinding.image);
        mealBinding.name.setText(category.getStrCategory());
        mealBinding.desc.setText(category.getStrInstructions());
        mealBinding.ingNum.setText("IngredientId: " +category.getIdMeal());

        mealBinding.fragSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                ref.child(Constants.CATEGORIES).child(category.getIdMeal()).setValue(category);
                Toast.makeText(getContext(), "Successfully Saved", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }


}