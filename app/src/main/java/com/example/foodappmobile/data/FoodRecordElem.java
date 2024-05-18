package com.example.foodappmobile.data;



public class FoodRecordElem {
private String name;
private String description;
private String image_id;

    public FoodRecordElem(String name, String description, String image_id) {
        this.name = name;
        this.description = description;
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
}