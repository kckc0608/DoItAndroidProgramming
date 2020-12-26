package com.example.proj3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView1, scrollView2;
    ImageView imageView1, imageView2;
    BitmapDrawable bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView1 = findViewById(R.id.scrollView);
        imageView1 = findViewById(R.id.imageView1);
        scrollView1.setHorizontalScrollBarEnabled(true);

        scrollView2 = findViewById(R.id.scrollView2);
        imageView2 = findViewById(R.id.imageView2);
        scrollView2.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.cover1);
        int bitmapWidth =bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView1.setImageDrawable(bitmap);
        imageView1.getLayoutParams().width = bitmapWidth;
        imageView1.getLayoutParams().height = bitmapHeight;

        imageView2.setImageDrawable(bitmap);
        imageView2.getLayoutParams().width = bitmapWidth;
        imageView2.getLayoutParams().height = bitmapHeight;
        imageView2.setVisibility(ImageView.INVISIBLE);
    }

    public void onButtonUpClicked(View v) {
        imageView1.setVisibility(ImageView.VISIBLE);
        imageView2.setVisibility(ImageView.INVISIBLE);
    }

    public void onButtonDownClicked(View v) {
        imageView1.setVisibility(ImageView.INVISIBLE);
        imageView2.setVisibility(ImageView.VISIBLE);
    }
}