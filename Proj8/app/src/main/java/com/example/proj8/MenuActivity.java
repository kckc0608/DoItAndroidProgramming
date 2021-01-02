package com.example.proj8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public final int CUSTOMER = 101, SELL = 102, STOCK = 103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onButtonClicked(View v) {
        Intent intent = new Intent(this, SubMenu1.class);
        switch (v.getId()) {
            case R.id.button1: // 고객 관리
                startActivityForResult(intent, CUSTOMER);
                break;
            case R.id.button2: // 매출 관리
                startActivityForResult(intent, SELL);
                break;
            case R.id.button3: // 상품 관리
                startActivityForResult(intent, STOCK);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent recvIntent = data;
        String from="", to = recvIntent.getStringExtra("to");
        switch (requestCode) {
            case CUSTOMER:
                from = "customer";
                break;
            case SELL:
                from = "sell";
                break;
            case STOCK:
                from = "stock";
                break;
        }

        if (to.equals("login")) {
            Intent sendIntent = new Intent();
            sendIntent.putExtra("to", "login");
            sendIntent.putExtra("from",from);
            setResult(RESULT_OK, sendIntent);
            finish();
        } else if (to.equals("menu")) {
            Toast.makeText(this, "it comes from " + from, Toast.LENGTH_SHORT).show();
        }
    }
}