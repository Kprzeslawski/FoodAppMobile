package com.example.foodappmobile.data;


import kotlin.ParameterName;

public class FoodRecordElem {

private Integer count;

private String name;
private String description;
private Integer image_id;
private Double kcal;
private Double protein;
private Double carbs;
private Double fat;

    public FoodRecordElem(String name, String description, Integer image_id, Double kcal, Double protein, Double carbs, Double fat) {
        this.count = 0;
        this.name = name;
        this.description = description;
        this.image_id = image_id;
        this.kcal = kcal;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    @Deprecated
    public FoodRecordElem(String name, String description, Integer image_id) {
        this.count = 0;
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

    public Integer getImage_id() {
        return image_id;
    }

    public Integer getCount() {return count;}

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public Double getKcal() {
        return kcal;
    }

    public Double getProtein() {
        return protein;
    }

    public Double getCarbs() {
        return carbs;
    }

    public Double getFat() {
        return fat;
    }

    public void increaseCount(){this.count++;}
    public void decreaseCount(){if(this.count > 0)this.count--;}
}
