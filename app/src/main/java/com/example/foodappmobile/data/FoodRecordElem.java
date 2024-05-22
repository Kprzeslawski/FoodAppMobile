package com.example.foodappmobile.data;



public class FoodRecordElem {

private Integer count;

    private String name;
private String description;
private Integer image_id;

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

    public Integer getCount() {
        return count;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }
}
