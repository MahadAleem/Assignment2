package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.assignment2.database.MDataBase;

public class MainActivity extends AppCompatActivity {

    static public MDataBase mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       getSupportActionBar().setTitle("Viva Schedule System");
        mDataBase = Room.databaseBuilder(this, MDataBase.class, getResources().getString(R.string.app_name))
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        Button studentEnrolmentForm = findViewById(R.id.buttonEnrolmentForm);
        Button studentVivaSchedule = findViewById(R.id.buttonVivaSchedule);
        Button studentVivaView = findViewById(R.id.buttonView);

        studentEnrolmentForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enrolmentFormIntent = new Intent(MainActivity.this,StudentEnrolmentFormActivity.class);
                startActivity(enrolmentFormIntent);
            }
        });
        studentVivaSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent studentVivaIntent = new Intent(MainActivity.this,VivaScheduleActivity.class);
                startActivity(studentVivaIntent);
            }
        });
        studentVivaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent studentVivaViewIntent = new Intent(MainActivity.this,ViewVivaScheduleActivity.class);
                startActivity(studentVivaViewIntent);
            }
        });
    }
}