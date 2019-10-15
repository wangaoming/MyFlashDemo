package com.example.myflashdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1,button2,button3;
//补间动画
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        button1 = findViewById ( R.id.btn_tween );
        button2= findViewById ( R.id.btn_zhen );
        button3 = findViewById ( R.id.btn_shuxing  );
        button1.setOnClickListener ( this );
        button2.setOnClickListener ( this );
        button3.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v){
        switch (v.getId ()){
            case R.id.btn_tween:

                Intent intent  = new Intent ( MainActivity.this,TweenActivity.class );
                startActivity ( intent );
                break;
//                帧动画
            case R.id.btn_zhen:
                Intent intent1  = new Intent ( MainActivity.this,FrameAnimationActivity.class );
                startActivity ( intent1 );
                break;
//                属性动画
            case R.id.btn_shuxing:
                Intent intent2  = new Intent ( MainActivity.this,ValueAnimationActivity.class );
                startActivity ( intent2 );
                break;
        }
    }
}
