package com.example.studentmarkstoring.studentmarkstoring.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ITDepartmentRepository {
    public ITDao itDao;

    LiveData<List<Student>> studentList;


    public ITDepartmentRepository(Application application){
        ITDatabase itDatabase = ITDatabase.getInstance(application.getApplicationContext());
        this.itDao = itDatabase.itDao();
        studentList = itDao.getStudents();
    }

    public LiveData<List<Student>> getStudentList(){
        return studentList;
    }

    public void studentEntry(Student student){
        new StudentEntryTask(itDao).execute(student);
    }

    public class StudentEntryTask extends AsyncTask<Student,Void,Long>{
        public ITDao itDao;
        StudentEntryTask(ITDao itDao){
            this.itDao = itDao;
        }

        @Override
        protected Long doInBackground(Student... students) {

            return itDao.insertEntry(students[0]);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
        }
    }
}
