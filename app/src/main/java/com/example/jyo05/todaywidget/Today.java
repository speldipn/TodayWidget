package com.example.jyo05.todaywidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Oh, Joon young (speldipn)
 * @Since: 2018-11-04
 */
public class Today extends android.support.v7.widget.AppCompatTextView {
    public Today(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Today);
        int size = typedArray.getIndexCount();
        for (int i = 0; i < size; ++i) {
            int idx = typedArray.getIndex(i);
            switch (idx) {
                case R.styleable.Today_delimeter:
                    String delimeter = typedArray.getString(idx);
                    setToday(delimeter);
                    break;
            }
        }
    }

    private void setToday(String delimeter) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + delimeter + "MM" + delimeter + "dd");
        String today = sdf.format(date);
        setText(today);
    }
}