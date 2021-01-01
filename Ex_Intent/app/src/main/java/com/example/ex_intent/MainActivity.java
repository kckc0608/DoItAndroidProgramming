package com.example.ex_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, SubActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.Settings");
                startActivity(intent);
                break;
            case R.id.button3:intent = new Intent(); // 기본 인텐트
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"), "image/*");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);
                break;
        }
    }
}