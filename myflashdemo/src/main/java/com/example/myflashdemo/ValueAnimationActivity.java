package com.example.myflashdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class ValueAnimationActivity extends AppCompatActivity implements View.OnClickListener {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_value_animation );
        textView = findViewById ( R.id.tv_value );
        Button btnValue = findViewById ( R.id.btn_value );
        Button  btnObject = findViewById ( R.id.btn_object );
        Button btnSet = findViewById ( R.id.btn_set );
        Button  btnCustom = findViewById ( R.id.btn_custom );
        btnCustom.setOnClickListener ( this );
        btnSet.setOnClickListener ( this );
        btnObject.setOnClickListener ( this );
        btnValue.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.btn_value:
                startValueAnimation();
                break;
            case R.id.btn_object:
                startObjectAnimation();
                break;
            case R.id.btn_set:
                startAnimationSet();
                break;
            case R.id.btn_custom:
                startCustomAnimation();
        }

    }

    private void startCustomAnimation() {
        ObjectAnimator animator =  ObjectAnimator.ofObject (textView,"x",new TranslateXEvalutor(),0,300 );
        animator.setDuration ( 3000 );
        animator.start ( );
    }

    private void startAnimationSet() {
//        动画效果：透明度，常规=全透明-常规
        ObjectAnimator alpha = ObjectAnimator.ofFloat ( textView,"alpha",1f,0f,1f );
        alpha.setDuration ( 5000 );
        alpha.start ();
//        旋转
        ObjectAnimator rotation = ObjectAnimator.ofFloat ( textView,"rotation",0f,360f );
//       平移
        float currentX = textView.getX ();
        ObjectAnimator translationX = ObjectAnimator.ofFloat ( textView,"translationX",currentX,currentX+3 );
//        缩放
        ObjectAnimator scaleX = ObjectAnimator.ofFloat ( textView,"scaleX",1f
        ,3f,1f);

//动画的组合
        AnimatorSet set  = new AnimatorSet (  );
        set.play ( translationX ).with(rotation).before ( scaleX );
        set.start ();
    }

    private void startObjectAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "alpha", 0.0f, 1.0f);

//        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.set_object_animator);

        animator.setTarget(textView);

        animator.setDuration(3000);

        animator.start();
    }


    private void startValueAnimation() {//        1.设置动画属性的初始值、结束值
//        方法一 动态设置
        ValueAnimator animator = ValueAnimator.ofFloat ( 0.0f,1.0f,0.5f );

// 第2 种方式：加载animator目录下的xml文件

//
//        ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.set_value_animator);
//设置播放时长
        animator.setDuration ( 3000 );
//        增加动画属性值的更新监听器
        animator.addUpdateListener ( new ValueAnimator.AnimatorUpdateListener ( ) {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                1.获取属性值
                float value = (float)animation.getAnimatedValue ();
//                2给控件对象赋值
                textView.setAlpha ( value );


            }
        } );
        //                启动
        animator.start ();
    }


}
