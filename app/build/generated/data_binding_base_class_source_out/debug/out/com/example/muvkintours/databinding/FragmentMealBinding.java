// Generated by view binder compiler. Do not edit!
package com.example.muvkintours.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.ScrollView;
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

public final class FragmentMealBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextView category;

  @NonNull
  public final ConstraintLayout cont1;

  @NonNull
  public final TextView desc;

  @NonNull
  public final MaterialButton fragSave;

  @NonNull
  public final ShapeableImageView image;

  @NonNull
  public final TextView ingNum;

  @NonNull
  public final TextView name;

  @NonNull
  public final RatingBar rate;

  private FragmentMealBinding(@NonNull ScrollView rootView, @NonNull TextView category,
      @NonNull ConstraintLayout cont1, @NonNull TextView desc, @NonNull MaterialButton fragSave,
      @NonNull ShapeableImageView image, @NonNull TextView ingNum, @NonNull TextView name,
      @NonNull RatingBar rate) {
    this.rootView = rootView;
    this.category = category;
    this.cont1 = cont1;
    this.desc = desc;
    this.fragSave = fragSave;
    this.image = image;
    this.ingNum = ingNum;
    this.name = name;
    this.rate = rate;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMealBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMealBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_meal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMealBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.category;
      TextView category = ViewBindings.findChildViewById(rootView, id);
      if (category == null) {
        break missingId;
      }

      id = R.id.cont1;
      ConstraintLayout cont1 = ViewBindings.findChildViewById(rootView, id);
      if (cont1 == null) {
        break missingId;
      }

      id = R.id.desc;
      TextView desc = ViewBindings.findChildViewById(rootView, id);
      if (desc == null) {
        break missingId;
      }

      id = R.id.fragSave;
      MaterialButton fragSave = ViewBindings.findChildViewById(rootView, id);
      if (fragSave == null) {
        break missingId;
      }

      id = R.id.image;
      ShapeableImageView image = ViewBindings.findChildViewById(rootView, id);
      if (image == null) {
        break missingId;
      }

      id = R.id.ingNum;
      TextView ingNum = ViewBindings.findChildViewById(rootView, id);
      if (ingNum == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.rate;
      RatingBar rate = ViewBindings.findChildViewById(rootView, id);
      if (rate == null) {
        break missingId;
      }

      return new FragmentMealBinding((ScrollView) rootView, category, cont1, desc, fragSave, image,
          ingNum, name, rate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
