package com.example.proj4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText msg;
    TextView countByte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);

        msg = findViewById(R.id.editText);
        countByte = findViewById(R.id.textView);

        msg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
                countByte.setText(count + "/80 바이트");
            }

            @Override
            public void afterTextChanged(Editable s) {
                countByte.setText(s.toString().length() + "/80 바이트");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                countByte.setText(count + "/80 바이트");
            }
        });
    }

    public void onButton1Clicked(View v) {
        Toast.makeText(this,msg.getText().toString(), Toast.LENGTH_LONG).show();
    }
    public void onButton2Clicked(View v) {
        finish();
    }
}