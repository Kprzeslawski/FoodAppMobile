package com.example.foodappmobile.data;

import com.example.foodappmobile.R;

import java.util.ArrayList;
import java.util.List;

public class FoodStaticData {
    public static List<FoodRecordElem> foodList = new ArrayList<FoodRecordElem>(){{
        add(new FoodRecordElem(
            "Egg", "Simple egg eat it as u want!", R.drawable.egg
        ));
    }};
}
