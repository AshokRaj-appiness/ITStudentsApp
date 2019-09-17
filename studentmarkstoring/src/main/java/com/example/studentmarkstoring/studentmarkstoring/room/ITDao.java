package com.example.studentmarkstoring.studentmarkstoring.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ITDao {
    @Insert
    long insertEntry(Student student);

    @Query("SELECT * FROM IT_Table")
    LiveData<List<Student>> getStudents();
}
