package com.example.foodappmobile.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.foodappmobile.R;

public class FoodListElemComponent extends ConstraintLayout {
    private TextView countValue;
    private Button buttonAddValue;
    private Button buttonDecreaseValue;

    public FoodListElemComponent(Context context) {
        super(context);
        init(context,null, 0);
    }

    public FoodListElemComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0);
    }

    public FoodListElemComponent(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.food_list_comp_temp, this);

        countValue = (TextView)findViewById(R.id.countValue);
        buttonAddValue = (Button) findViewById(R.id.buttonAddValue);
        buttonDecreaseValue = (Button) findViewById(R.id.buttonDecreaseValue);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */
}