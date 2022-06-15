package com.example.muvkintours.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muvkintours.MealDetailActivity;
import com.example.muvkintours.R;
import com.example.muvkintours.mealApi.Constants;
import com.example.muvkintours.models.Meals;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class MealRecyclerAdapter extends RecyclerView.Adapter<MealRecyclerAdapter.myHolder> {

    List<Meals> allCats;
    Context context;

    public MealRecyclerAdapter(List<Meals> allCats, Context context) {
        this.allCats = allCats;
        this.context = context;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
        return new myHolder(v, this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        holder.setData(allCats.get(position));

    }

    @Override
    public int getItemCount() {
        return allCats.size();
    }

    public class myHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView mealName, mealDesc;
        ShapeableImageView mealImage;
        MaterialButton save, readMore;
        Context cont;
        Meals meal;


        public myHolder(@NonNull View itemView, Context context) {
            super(itemView);

            mealName = itemView.findViewById(R.id.mealName);
            mealDesc = itemView.findViewById(R.id.mealPrice);
            mealImage = itemView.findViewById(R.id.mealImage);
            save = itemView.findViewById(R.id.save);
            readMore = itemView.findViewById(R.id.readMore);
            this.cont = context;

            itemView.setOnClickListener(this);
            save.setOnClickListener(this);
            readMore.setOnClickListener(this);

        }

        public void setData(Meals cat){
            mealName.setText(cat.getStrMeal());
            mealDesc.setText(cat.getStrInstructions()+ "....");
            Picasso.get().load(cat.getStrMealThumb()).into(mealImage);

            meal = cat;

        }

        @Override
        public void onClick(View v) {

            if (v == itemView || v == readMore){

                int position = getLayoutPosition();
                Intent detail = new Intent(cont, MealDetailActivity.class);
                detail.putExtra("position", position);
                detail.putExtra("cats", (Serializable) allCats);
                cont.startActivity(detail);
          }
            else if (v == save){

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(Constants.CATEGORIES);

                ref.child(meal.getIdMeal()).setValue(meal);

                Toast.makeText(cont, "Successfully submitted", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
