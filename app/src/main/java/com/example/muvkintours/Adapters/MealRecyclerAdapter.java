package com.example.muvkintours.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muvkintours.MealDetailActivity;
import com.example.muvkintours.R;
import com.example.muvkintours.models.Category;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

public class MealRecyclerAdapter extends RecyclerView.Adapter<MealRecyclerAdapter.myHolder> {

    List<Category> allCats;
    Context context;

    public MealRecyclerAdapter(List<Category> allCats, Context context) {
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
        TextView mealName;
        TextView mealDesc;
        ShapeableImageView mealImage;
        Context cont;


        public myHolder(@NonNull View itemView, Context context) {
            super(itemView);

            mealName = itemView.findViewById(R.id.mealName);
            mealDesc = itemView.findViewById(R.id.mealPrice);
            mealImage = itemView.findViewById(R.id.mealImage);
            this.cont = context;

            itemView.setOnClickListener(this);

        }

        public void setData(Category cat){
            mealName.setText(cat.getStrCategory());
            mealDesc.setText(cat.getStrCategoryDescription() + "....");
            Picasso.get().load(cat.getStrCategoryThumb()).into(mealImage);
        }

        @Override
        public void onClick(View v) {

            int position = getLayoutPosition();
            Intent detail = new Intent(cont, MealDetailActivity.class);
            detail.putExtra("position", position);
            detail.putExtra("cats", Parcels.wrap(allCats));
            cont.startActivity(detail);

        }
    }
}
