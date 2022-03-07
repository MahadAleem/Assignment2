package com.example.assignment2;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment2.adapter.AdapterModel;
import com.example.assignment2.adapter.VivaScheduleViewAdapter;
import com.example.assignment2.database.VivaEntities;

import java.util.ArrayList;
import java.util.List;

public class ViewVivaScheduleActivity extends AppCompatActivity {

    VivaScheduleViewAdapter vivaScheduleViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_viva_schedule);

        RecyclerView recyclerView= findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<AdapterModel> adapterModelList = new ArrayList<>();
        List<VivaEntities> vivaEntitiesList = MainActivity.mDataBase.mdoa().fetchVivaData();
        for (VivaEntities vivaEntities: vivaEntitiesList){
            List<String> name = MainActivity.mDataBase.mdoa().fetchStudentDataByID(vivaEntities.getStudentId());
            for (String  a : name){
                adapterModelList.add(new AdapterModel(a,vivaEntities.getTime(),vivaEntities.getDate()));
                Log.i("mdoa", "onCreate: "+vivaEntities.getTime()+" date:"+vivaEntities.getDate()+" name:"+a);
            }
        }
        vivaScheduleViewAdapter=new VivaScheduleViewAdapter(adapterModelList);
        recyclerView.setAdapter(vivaScheduleViewAdapter);
    }
}