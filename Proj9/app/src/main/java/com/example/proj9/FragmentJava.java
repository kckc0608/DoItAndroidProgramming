package com.example.proj9;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

public class FragmentJava extends Fragment {

    EditText editTextName, editTextOld;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_layout_, container, false);

        editTextName = rootView.findViewById(R.id.editTextName);
        editTextOld = rootView.findViewById(R.id.editTextOld);
        Button buttonBirth = rootView.findViewById(R.id.buttonBirth);
        Button buttonSave = rootView.findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "name : " + editTextName.getText().toString() +
                        "\nOld : " + editTextOld.getText().toString() +
                        "\nDate : " + buttonBirth.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });



        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                buttonBirth.setText(year + "년 " + (month+1) + "월 " + dayOfMonth + "일");
            }
        };

        buttonBirth.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), dateSetListener, 2021, 0, 3);
                datePickerDialog.show();
            }
        });

        return rootView;
    }
}
