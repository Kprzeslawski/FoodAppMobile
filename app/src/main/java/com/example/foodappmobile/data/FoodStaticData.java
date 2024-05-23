package com.example.foodappmobile.data;

import com.example.foodappmobile.R;

import java.util.ArrayList;
import java.util.List;

public class FoodStaticData {
    public static List<FoodRecordElem> foodList = new ArrayList<FoodRecordElem>(){{
        add(new FoodRecordElem(
            "Egg", "Simple egg eat it as u want!", R.drawable.egg, 5.,5.,5.,5.
        ));
        add(new FoodRecordElem(
                "Milk", "You did what to cow to get that????", R.drawable.mleko, 5.,5.,5.,5.
        ));
        add(new FoodRecordElem(
                "Orange Juice", "Perfectly refreshing and sweet", R.drawable.orange_juice, 5.,5.,5.,5.
        ));
        add(new FoodRecordElem(
                "Pizza", "Pizza always can fill me up ;)", R.drawable.pizza, 5.,5.,5.,5.
        ));
        add(new FoodRecordElem(
                "Uranium-235", "Only 20 000 000kcal in one gram", R.drawable.uran, 5.,5.,5.,5.
        ));
        add(new FoodRecordElem(
                "Tiramisu", "Mam ochote na tiramisu xd", R.drawable.tiramisu, 5.,5.,5.,5.
        ));
    }};
}
