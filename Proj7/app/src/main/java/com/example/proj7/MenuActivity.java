package com.example.proj7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onButtonClicked(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button1: // 고객 관리
                intent = new Intent();
                intent.putExtra("name", "고객관리");
                setResult(RESULT_OK, intent);
                finish();
                break;

            case R.id.button2: // 매출 관리
                intent = new Intent();
                intent.putExtra("name", "매출관리");
                setResult(RESULT_OK, intent);
                finish();
                break;

            case R.id.button3: // 상품 관리
                intent = new Intent();
                intent.putExtra("name", "상품관리");
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}