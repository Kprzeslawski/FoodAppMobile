package com.example.foodappmobile.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
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

        createTable();

    }
    public void createTable(){

        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setColumnStretchable(0,true);
        tableLayout.setColumnStretchable(2,true);
        tableLayout.setColumnStretchable(4,true);
        tableLayout.setColumnStretchable(6,true);
        tableLayout.setColumnStretchable(8,true);
        tableLayout.setColumnStretchable(10,true);

        tableLayout.addView(createBar(4));
        TableRow header = createTableRow(new String[]{"Food Name", "Count", "Kcal", "Protein", "Carbs", "Fat"});

        header.setBackgroundColor(Color.LTGRAY);
        tableLayout.addView(header);


        for (FoodRecordElem elem : FoodStaticData.foodList)
            if (elem.getCount() > 0) {
                tableLayout.addView(createBar(4));
                tableLayout.addView(createTableRow(new String[]{elem.getName(), String.valueOf(elem.getCount()), "0", "0", "0", "0"}));
            }

        TableRow summary = new TableRow(this);

        TextView tv = new TextView(this);
        tv.setText("Total");
        tv.setGravity(Gravity.CENTER);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        layoutParams.span = 3;
        tv.setLayoutParams(layoutParams);
        summary.addView(tv);

        View v = new View(this);
        v.setBackgroundColor(Color.BLACK);
        v.setLayoutParams(new TableRow.LayoutParams(4, ViewGroup.LayoutParams.MATCH_PARENT));
        summary.addView(v);



        tableLayout.addView(createBar(4));
        tableLayout.addView(summary);
        tableLayout.addView(createBar(4));

        ((LinearLayout) findViewById(R.id.add_rec_list)).addView(tableLayout);
    }

    public TableRow createTableRow(String[] values){
        TableRow res = new TableRow(this);

        boolean first = true;

        for (String s : values) {

            if(!first){
                View v = new View(this);
                v.setBackgroundColor(Color.BLACK);
                v.setLayoutParams(new TableRow.LayoutParams(4, ViewGroup.LayoutParams.MATCH_PARENT));
                res.addView(v);
            }else first = false;

            TextView tv = new TextView(this);
            tv.setText(s);
            tv.setGravity(Gravity.CENTER);
            res.addView(tv);

        }
        return res;
    }

    public View createBar(int h){
        View v = new View(this);
        v.setBackgroundColor(Color.BLACK);
        v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 4));
        return v;
    }
}