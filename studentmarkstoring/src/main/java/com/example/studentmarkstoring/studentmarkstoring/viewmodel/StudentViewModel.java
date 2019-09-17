package com.example.studentmarkstoring.studentmarkstoring.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.studentmarkstoring.studentmarkstoring.room.ITDepartmentRepository;
import com.example.studentmarkstoring.studentmarkstoring.room.Student;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private ITDepartmentRepository itDepartmentRepository;
    public StudentViewModel(@NonNull Application application) {
        super(application);
        itDepartmentRepository = new ITDepartmentRepository(application);
    }

    public LiveData<List<Student>> getStudents(){
        return itDepartmentRepository.getStudentList();
    }

    public void insertStudents(Student student){
        itDepartmentRepository.studentEntry(student);
    }


}
