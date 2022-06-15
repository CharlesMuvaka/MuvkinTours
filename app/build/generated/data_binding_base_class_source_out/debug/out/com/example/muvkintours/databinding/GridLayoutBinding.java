// Generated by view binder compiler. Do not edit!
package com.example.muvkintours.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.muvkintours.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class GridLayoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout gridLayout;

  @NonNull
  public final ShapeableImageView mealImage;

  @NonNull
  public final TextView mealName;

  @NonNull
  public final TextView mealPrice;

  @NonNull
  public final TextView price;

  @NonNull
  public final RatingBar rating;

  @NonNull
  public final MaterialButton readMore;

  @NonNull
  public final MaterialButton save;

  private GridLayoutBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout gridLayout, @NonNull ShapeableImageView mealImage,
      @NonNull TextView mealName, @NonNull TextView mealPrice, @NonNull TextView price,
      @NonNull RatingBar rating, @NonNull MaterialButton readMore, @NonNull MaterialButton save) {
    this.rootView = rootView;
    this.gridLayout = gridLayout;
    this.mealImage = mealImage;
    this.mealName = mealName;
    this.mealPrice = mealPrice;
    this.price = price;
    this.rating = rating;
    this.readMore = readMore;
    this.save = save;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static GridLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static GridLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.grid_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static GridLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout gridLayout = (ConstraintLayout) rootView;

      id = R.id.mealImage;
      ShapeableImageView mealImage = ViewBindings.findChildViewById(rootView, id);
      if (mealImage == null) {
        break missingId;
      }

      id = R.id.mealName;
      TextView mealName = ViewBindings.findChildViewById(rootView, id);
      if (mealName == null) {
        break missingId;
      }

      id = R.id.mealPrice;
      TextView mealPrice = ViewBindings.findChildViewById(rootView, id);
      if (mealPrice == null) {
        break missingId;
      }

      id = R.id.price;
      TextView price = ViewBindings.findChildViewById(rootView, id);
      if (price == null) {
        break missingId;
      }

      id = R.id.rating;
      RatingBar rating = ViewBindings.findChildViewById(rootView, id);
      if (rating == null) {
        break missingId;
      }

      id = R.id.readMore;
      MaterialButton readMore = ViewBindings.findChildViewById(rootView, id);
      if (readMore == null) {
        break missingId;
      }

      id = R.id.save;
      MaterialButton save = ViewBindings.findChildViewById(rootView, id);
      if (save == null) {
        break missingId;
      }

      return new GridLayoutBinding((ConstraintLayout) rootView, gridLayout, mealImage, mealName,
          mealPrice, price, rating, readMore, save);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
