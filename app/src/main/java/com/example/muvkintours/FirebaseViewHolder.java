package com.example.muvkintours;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muvkintours.models.Meals;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {
    View layout;
    Context context;

    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.layout = itemView;
        this.context = itemView.getContext();

    }

    public void setdata(Meals meal){

        ShapeableImageView mealImage = layout.findViewById(R.id.mealImage);
        TextView mealname = layout.findViewById(R.id.mealName);
        TextView mealdesc = layout.findViewById(R.id.mealPrice);
        MaterialButton save = layout.findViewById(R.id.save);
        MaterialButton readMore = layout.findViewById(R.id.readMore);

        save.setVisibility(View.GONE);
        readMore.setVisibility(View.GONE);
        readMore.setLayoutParams(new ViewGroup.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT));

        Picasso.get().load(meal.getStrMealThumb()).into(mealImage);
        mealname.setText(meal.getStrMeal());
        mealdesc.setText(meal.getStrInstructions());

    }

}
