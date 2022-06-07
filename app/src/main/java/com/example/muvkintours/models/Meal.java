
package com.example.retrofit.models;

import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Meal {

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meal() {
    }

    /**
     * 
     * @param categories
     */
    public Meal(List<Category> categories) {
        super();
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
