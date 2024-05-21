package com.example.foodappmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodappmobile.activities.SummaryActivity;
import com.example.foodappmobile.components.FoodListElemComponent;
import com.example.foodappmobile.data.FoodRecordElem;
import com.example.foodappmobile.data.FoodStaticData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for (FoodRecordElem rec : FoodStaticData.foodList) {
            FoodListElemComponent foodListElemComponent = new FoodListElemComponent(this);
            foodListElemComponent.setTitle(rec.getName());
            foodListElemComponent.setDescription(rec.getDescription());
            foodListElemComponent.setImageById(rec.getImage_id());

            ((LinearLayout) findViewById(R.id.food_item_list_layout)).addView(foodListElemComponent);

        }

        ((Button) findViewById(R.id.main_summary_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {switchActivities();}
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, SummaryActivity.class);
        startActivity(switchActivityIntent);
    }
}