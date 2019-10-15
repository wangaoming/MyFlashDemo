package com.example.myflashdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import javax.xml.transform.Templates;

public class TweenActivity extends AppCompatActivity {
    private ImageView inInside,inOuter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_tween );
        inInside  = findViewById ( R.id.iv_inside_circle );
        inOuter  = findViewById ( R.id.iv_outer_circle );
        textView = findViewById ( R.id.tv_view );
//       插值器 --旋转
Animation outerCircle = AnimationUtils.loadAnimation ( this,R.anim.anim_out_rotate );
outerCircle.setInterpolator ( new LinearInterpolator (  ) );


Animation insideCircle = AnimationUtils.loadAnimation ( this,R.anim.anim_inside_rotate );
insideCircle.setInterpolator ( new LinearInterpolator (  ) );

        inInside.startAnimation ( insideCircle );
inOuter.startAnimation ( outerCircle );




    }

    public void onClick(View view) {
        switch (view.getId ()){
             //移动
            case R.id.btn_translation:
             //加载动画 根据anim/xml的 静态创建
//                Animation  animation  = AnimationUtils.loadAnimation ( this,R.anim.anim_translate );
//                textView.startAnimation ( animation );
//                动态创建
                Animation animation =new TranslateAnimation(0,100,0,300);
                animation.setDuration ( 3000 );
                textView.startAnimation ( animation );
                break;
            case  R.id.btn_scale:
            //缩放动画

                  animation  = AnimationUtils.loadAnimation ( this,R.anim.anim_scale );
               textView.startAnimation ( animation );
//               将所有效果组合重现
            case  R.id.btn_set:
                animation = AnimationUtils.loadAnimation ( this,R.anim.anim_view_set );
                textView.startAnimation ( animation );
            break;
        }
    }
}
