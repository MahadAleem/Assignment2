package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2.database.StudentEntities;

public class StudentEnrolmentFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_enrolment_form);
        EditText id = findViewById(R.id.personID);
        EditText name = findViewById(R.id.studentName);
        EditText course = findViewById(R.id.courseEnroled);
        EditText mobile = findViewById(R.id.mobileNo);
        Button buttonSave = findViewById(R.id.save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.getText().toString().isEmpty() || name.getText().toString().isEmpty() || course.getText().toString().isEmpty() || mobile.getText().toString().isEmpty()) {
                    Toast.makeText(StudentEnrolmentFormActivity.this, "Please Insert All Data", Toast.LENGTH_SHORT).show();
                } else {
                    StudentEntities studentEntities = new StudentEntities();
                    studentEntities.setStudentId(id.getText().toString());
                    studentEntities.setStudentName(name.getText().toString());
                    studentEntities.setCourseEnrolled(course.getText().toString());
                    studentEntities.setMobileNumber(mobile.getText().toString());
                    MainActivity.mDataBase.mdoa().inset(studentEntities);
                    Toast.makeText(StudentEnrolmentFormActivity.this, "Student Enrolment is Saved Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}