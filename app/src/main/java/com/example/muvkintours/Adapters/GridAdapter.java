package com.example.muvkintours.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.muvkintours.R;
import com.google.android.material.imageview.ShapeableImageView;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private String[] meals;
    private int[] images;

    public GridAdapter(Context context, String[] meals, int[] images) {
        this.context = context;
        this.meals = meals;
        this.images = images;
    }


    @Override
    public int getCount() {
        return meals.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.grid_layout, null);
        }

        TextView text = convertView.findViewById(R.id.mealName);
        ShapeableImageView image = convertView.findViewById(R.id.mealImage);

        text.setText(meals[position]);
        image.setImageResource(images[position]);

        return convertView;
    }
}
