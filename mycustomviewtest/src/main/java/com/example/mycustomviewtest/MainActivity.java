package com.example.mycustomviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
//自定义标题栏
public class MainActivity extends AppCompatActivity {
    private ImageView imageView1,imageView2;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        imageView1 = findViewById ( R.id.i_back );
        imageView2 = findViewById ( R.id.i_back1 );
        textView = findViewById ( R.id.tv_title );
    }
}
