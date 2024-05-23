package com.example.foodappmobile.activities;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodappmobile.R;
import com.example.foodappmobile.data.FoodRecordElem;
import com.example.foodappmobile.data.FoodStaticData;

import java.time.format.TextStyle;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.summary_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ((ImageButton) findViewById(R.id.summary_return_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        boolean any_elem = false;
        for (FoodRecordElem elem : FoodStaticData.foodList)
            if (elem.getCount() > 0) {
                any_elem = true;
                break;
            }

        if(!any_elem){
            TextView tv = new TextView(this);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(30);
            tv.setText("No food selected");

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0,10,0,0);
            tv.setLayoutParams(lp);

            ((LinearLayout) findViewById(R.id.add_rec_list)).addView(tv);
            return;
        }

        for (FoodRecordElem elem : FoodStaticData.foodList) {
            TextView tv = new TextView(this);
            tv.setText(String.valueOf(elem.getCount()));
            ((LinearLayout) findViewById(R.id.add_rec_list)).addView(tv);
        }

    }
}