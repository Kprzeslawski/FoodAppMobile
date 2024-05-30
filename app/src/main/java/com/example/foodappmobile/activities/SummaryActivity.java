package com.example.foodappmobile.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.example.foodappmobile.R;
import com.example.foodappmobile.data.FoodRecordElem;
import com.example.foodappmobile.data.FoodStaticData;

import java.util.ArrayList;
import java.util.List;

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

//        createTable();

        createPieChartWithAllFoodsSelected();

    }

    public void createPieChartWithAllFoodsSelected(){
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setMinimumWidth(200);
        anyChartView.setMinimumHeight(200);

        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Apples", 6371664));
        data.add(new ValueDataEntry("Pears", 789622));
        data.add(new ValueDataEntry("Bananas", 7216301));
        data.add(new ValueDataEntry("Grapes", 1486621));
        data.add(new ValueDataEntry("Oranges", 1200000));

        pie.data(data);
        pie.title("Fruits imported in 2015 (in kg)");

        pie.labels().position("outside");

        pie.legend().title().enabled(true);
        pie.legend().title()
                .text("Retail channels")
                .padding(0d, 0d, 10d, 0d);

        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        anyChartView.setChart(pie);

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

        double[] total = new double[]{0.,0.,0.,0.};

        for (FoodRecordElem elem : FoodStaticData.foodList)
            if (elem.getCount() > 0) {
                int multiply = elem.getCount();
                total[0] += elem.getKcal() * multiply;
                total[1] += elem.getProtein() * multiply;
                total[2] += elem.getCarbs() * multiply;
                total[3] += elem.getFat() * multiply;

                tableLayout.addView(createBar(4));
                tableLayout.addView(createTableRow(new String[]{elem.getName(), String.valueOf(elem.getCount()),
                        String.valueOf(elem.getKcal() * multiply), String.valueOf(elem.getProtein() * multiply),
                        String.valueOf(elem.getCarbs() * multiply), String.valueOf(elem.getFat() * multiply)}));
            }


        TableRow summary = createTableRow(new String[]{"Total",
                String.valueOf(total[0]), String.valueOf(total[1]),
                String.valueOf(total[2]), String.valueOf(total[3])});
        summary.setBackgroundColor(Color.LTGRAY);

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        layoutParams.span = 3;
        summary.getChildAt(0).setLayoutParams(layoutParams);

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