package com.example.mart;

public class ItemModel {

    private String item_name,item_description;
    private int item_rating;
    private int item_image;

    // Constructor
    public ItemModel(String item_name,String item_description, int item_rating, int item_image) {
        this.item_name = item_name;
        this.item_description = item_description;
        this.item_rating = item_rating;
        this.item_image = item_image;
    }

    // Getter and Setter
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public int getItem_rating() {
        return item_rating;
    }

    public void setItem_rating(int item_rating) {
        this.item_rating = item_rating;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}
