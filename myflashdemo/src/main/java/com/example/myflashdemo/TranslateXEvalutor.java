package com.example.myflashdemo;

import android.animation.TypeEvaluator;

class TranslateXEvalutor implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int value =  startValue + (int)(fraction * (endValue - startValue));

        return value;
    }
}
