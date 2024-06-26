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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.summary_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for (FoodRecordElem rec : FoodStaticData.foodList) {
            FoodListElemComponent foodListElemComponent = new FoodListElemComponent(this);
            foodListElemComponent.setElem(rec);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0,10,0,0);
            foodListElemComponent.setLayoutParams(lp);
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