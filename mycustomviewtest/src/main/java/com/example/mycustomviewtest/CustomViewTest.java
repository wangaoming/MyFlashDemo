package com.example.mycustomviewtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomViewTest extends LinearLayout {
    private ImageView imageView1,imageView2;
    private TextView textView;
    public CustomViewTest(Context context) {

        super ( context );
    }

    public CustomViewTest(Context context,AttributeSet attrs) {
        super ( context, attrs );
    }

//    public CustomViewTest(Context context, AttributeSet attrs, int defStyleAttr) {
//        //获取属性
//        TypedArray typedArray = context.obtainStyledAttributes ( attrs,R.styleable.CustomTooBar,defStyleAttr,0 );
////        获取坐标属性
//
//        super ( context, attrs, defStyleAttr );
    }
