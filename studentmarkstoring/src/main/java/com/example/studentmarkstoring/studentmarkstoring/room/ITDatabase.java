package com.example.studentmarkstoring.studentmarkstoring.room;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class ITDatabase extends RoomDatabase {
    public abstract ITDao itDao();
    private static ITDatabase INSTANCE = null;
    private LiveData<List<Student>> studentList;

    public static ITDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ITDatabase.class,"Adhiyamaan")
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }






}
