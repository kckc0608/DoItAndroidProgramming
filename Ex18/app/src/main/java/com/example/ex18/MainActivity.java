package com.example.ex18;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMsg("onCreate() called");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        editText = findViewById(R.id.editTextTextPersonName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showMsg("onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showMsg("onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showMsg("onDestroy called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showMsg("onPause() called");
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showMsg("onResume called");
        restoreState();
    }

    public void showMsg(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        Log.d("Main", data);
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", editText.getText().toString());
        editor.commit();
    }

    protected void clearState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if (pref != null && pref.contains("name")) {
            String name = pref.getString("name", "");
            editText.setText(name);
        }
    }
}