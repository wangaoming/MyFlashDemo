package com.example.mycustomtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.audiofx.Visualizer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class SimpleImageView extends View {
    //画笔
    private Paint mBitmapPaint;
//    图片 drawble
    private Drawable drawable;
    private  int  mWidth;
    private  int  mHeight;

    public SimpleImageView(Context context) {

       super ( context,null );
    }

    public SimpleImageView(Context context,  AttributeSet attrs) {
        super ( context, attrs );
        initAttrs ( attrs );
//        初始化属性
        mBitmapPaint = new Paint (  );
        mBitmapPaint.setAntiAlias (  true);
    }

    private void initAttrs(AttributeSet attrrs){
        if(attrrs !=null){
            //属性的一一设置
            TypedArray array = null;
            try {

            array = getContext ().obtainStyledAttributes ( attrrs,R.styleable.SimpleImageView );
//            更具图片id获取到Drawble
            drawable = array.getDrawable ( R.styleable.SimpleImageView_src );
//            测量Drawble对象的宽高
            measureDrawble();

            }finally {
                if(array!=null){
                    //  回收 -设置相对应
                    array.recycle ();
                }
            }

        }
    }
//初始化 得到宽高
    private void measureDrawble() {
        if(drawable ==null){
            throw new
                     RuntimeException ( "drawble 不能为空" );

        }
        mWidth = drawable.getIntrinsicWidth ();
        mHeight = drawable.getIntrinsicHeight ();


    }
//放大模式
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //设置view的宽和高为图片的宽和高

        //获取宽度的模式与大小
        int  widthMode = MeasureSpec.getMode ( widthMeasureSpec );
        int  width = MeasureSpec.getSize ( widthMeasureSpec );
//        高度的模式与大小
        int heightMode = MeasureSpec.getMode ( heightMeasureSpec );
        int   height =  MeasureSpec.getSize ( heightMeasureSpec );
//        设置view的高
        setMeasuredDimension (MeasuredWidth (widthMode,width) ,measureHeight (heightMode,height));
        super.onMeasure ( widthMeasureSpec, heightMeasureSpec );
    }

    private int measureHeight(int mode, int height) {  switch( mode)
    {
        case MeasureSpec.UNSPECIFIED:
        case MeasureSpec.AT_MOST:
            break;
        case MeasureSpec.EXACTLY:
            mHeight = height ;
            break;
    }
    return  mHeight;
    }


    private int MeasuredWidth(int mode, int width) {
        switch (mode){
        case MeasureSpec.UNSPECIFIED:
        case MeasureSpec.AT_MOST:
        break;
        case MeasureSpec.EXACTLY:
        mWidth = width;
        break;
    }
    return  mWidth;
    }
private Bitmap mBitmap;
    @Override
    protected void onDraw(Canvas canvas) {
        if (mBitmap == null){
            mBitmap = Bitmap.createScaledBitmap ( ImageUtils.drawableToBitmap (drawable ),getMeasuredWidth (),getMeasuredHeight (),true )
;
        canvas.drawBitmap ( mBitmap,getLeft (),getTop (),mBitmapPaint );}
            if(drawable ==null){
            return;
        }
//        绘制图片
//        canvas.drawBitmap ( ImageUtils.drawableToBitmap(drawable),getLeft (),getTop (),mBitmapPaint );
//        super.onDraw ( canvas );
    }

    public SimpleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super ( context, attrs, defStyleAttr );
    }

}
