package com.example.assignment2.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MDOA {

    @Insert
    void inset(StudentEntities studentEntities);

    @Insert
    void inset(VivaEntities vivaEntities);

    @Query("SELECT * FROM assignment")
    List<StudentEntities> fetch();

    @Query("SELECT studentName FROM assignment WHERE studentId =:insertedId")
    List<String> fetchStudentDataByID(String insertedId);

    @Query("SELECT studentId FROM assignment")
    List<String> fetchID();

    @Query("SELECT * FROM viva")
    List<VivaEntities> fetchVivaData();
}
