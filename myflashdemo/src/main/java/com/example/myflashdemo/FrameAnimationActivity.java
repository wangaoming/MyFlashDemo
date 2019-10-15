package com.example.myflashdemo;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class FrameAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivFrame;
    private AnimationDrawable drawable;
    private Button button1,button2;
    @Override
//    帧动画
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        button1  =findViewById ( R.id.btn_start );
        button2  = findViewById ( R.id.btn_stop );

        ivFrame = findViewById(R.id.iv_progress);
        drawable = (AnimationDrawable)ivFrame.getBackground();
//        启动帧动画
        drawable.start();
        button1 .setOnClickListener ( this );
        button2.setOnClickListener ( this );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.btn_start:
                drawable.start();
                break;
            case R.id.btn_stop:
                drawable.stop ();
        }
    }
//    动态动画的创建帧动画
    private  AnimationDrawable createAnimation(){
        AnimationDrawable animationDrawable = new AnimationDrawable ();
        for(int i = 0; i < 8; i++) {

            int id = getResources().getIdentifier("wait" + i, "drawable",

                    getPackageName());

            Drawable drawable = getResources().getDrawable(id);

            animationDrawable.addFrame(drawable, 100);

        }

        return animationDrawable;
        }

    }
