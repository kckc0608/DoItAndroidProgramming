package com.example.proj8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubMenu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu1);

        Button buttonToMenu = findViewById(R.id.button1);
        Button buttonToLogin = findViewById(R.id.button2);

        buttonToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("to", "login");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        buttonToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("to", "menu");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}