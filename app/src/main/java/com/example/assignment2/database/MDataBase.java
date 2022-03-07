package com.example.assignment2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {StudentEntities.class,VivaEntities.class},version = 3,exportSchema = false)
public abstract class MDataBase extends RoomDatabase {
    public abstract MDOA mdoa();
}
