package com.example.foodappmobile.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.foodappmobile.R;
import com.example.foodappmobile.data.FoodRecordElem;

public class FoodListElemComponent extends ConstraintLayout {
    private FoodRecordElem elem;

    private ImageView recordImgView;
    private TextView title;
    private TextView content;

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

        countValue = (TextView) findViewById(R.id.countValue);
        buttonAddValue = (Button) findViewById(R.id.buttonAddValue);
        buttonDecreaseValue = (Button) findViewById(R.id.buttonDecreaseValue);
        recordImgView = (ImageView) findViewById(R.id.record_img);
        title = (TextView) findViewById(R.id.record_title);
        content = (TextView)  findViewById(R.id.record_text);

        buttonAddValue.setOnClickListener(addButtonClickListener);
        buttonDecreaseValue.setOnClickListener(decButtonClickListener);
    }

    private OnClickListener addButtonClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = countValue.getText().toString();
            int newTextAsInt = Integer.parseInt(text) + 1;
            countValue.setText(String.valueOf(newTextAsInt));
            elem.increaseCount();
        }
    };

    private OnClickListener decButtonClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = countValue.getText().toString();
            int newTextAsInt = Integer.parseInt(text) - 1;
            if(newTextAsInt < 0)return;
            countValue.setText(String.valueOf(newTextAsInt));
            elem.decreaseCount();
        }
    };

    public void setElem(FoodRecordElem elem) {
        this.elem = elem;
        this.title.setText(elem.getName());
        this.content.setText(elem.getDescription());
        this.recordImgView.setImageResource(elem.getImage_id());
        this.countValue.setText(String.valueOf(elem.getCount()));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}