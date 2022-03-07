package com.example.assignment2;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2.database.VivaEntities;

import java.util.List;

public class VivaScheduleActivity extends AppCompatActivity {
    TextView buttonSetTime;
    TextView buttonDatePicker;
    Button btnSave;

    TimePickerDialog.OnTimeSetListener timePickerDialogListener = new TimePickerDialog.OnTimeSetListener() {
        @SuppressLint("NewApi")
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int i1) {
            String AM_PM;
            if (hourOfDay < 12) {
                AM_PM = "AM";
            } else {
                AM_PM = "PM";
            }
            buttonSetTime.setText("Time: " + timePicker.getHour() + ":" + timePicker.getMinute() + " " + AM_PM);
        }
    };
    DatePickerDialog.OnDateSetListener datePickerDialogListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {
            buttonDatePicker.setText("Year:" + year + " Month:" + month + " Date:" + date);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viva_schedule);

        buttonSetTime = findViewById(R.id.buttonSetTime);
        buttonDatePicker = findViewById(R.id.buttonDatePicker);
        btnSave = findViewById(R.id.save);

        buttonSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(VivaScheduleActivity.this, timePickerDialogListener, 12, 10, false);
                timePickerDialog.show();
            }
        });
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(VivaScheduleActivity.this, datePickerDialogListener, 2021, 5, 12);
                datePickerDialog.show();
            }
        });

        List<String> fetchIDList = MainActivity.mDataBase.mdoa().fetchID();
        AutoCompleteTextView autoTextView = (AutoCompleteTextView) findViewById(R.id.personID);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, fetchIDList);
        autoTextView.setThreshold(1);
        autoTextView.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonDatePicker.getText().toString().equals("Pick Date") || buttonSetTime.getText().toString().equals("Set Time") || autoTextView.getText().toString().isEmpty()) {
                    Toast.makeText(VivaScheduleActivity.this, "Please insert all Information", Toast.LENGTH_SHORT).show();
                } else {
                    VivaEntities vivaEntities = new VivaEntities();
                    vivaEntities.setDate(buttonDatePicker.getText().toString());
                    vivaEntities.setTime(buttonSetTime.getText().toString());
                    vivaEntities.setStudentId(autoTextView.getText().toString());
                    MainActivity.mDataBase.mdoa().inset(vivaEntities);
                    Toast.makeText(VivaScheduleActivity.this, "Viva Schedule Saved Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}