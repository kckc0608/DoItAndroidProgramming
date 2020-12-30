package com.example.proj6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    SeekBar seekBar;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        seekBar = findViewById(R.id.seekBar);
        editText = findViewById(R.id.editTextTextPersonName);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    progressBar.setProgress(progress);
                    editText.setText(progress+"");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                progressBar.setProgress(seekBar.getProgress());
                editText.setText(seekBar.getProgress()+"");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                progressBar.setProgress(seekBar.getProgress());
                editText.setText(seekBar.getProgress()+"");
            }
        });
    }
}