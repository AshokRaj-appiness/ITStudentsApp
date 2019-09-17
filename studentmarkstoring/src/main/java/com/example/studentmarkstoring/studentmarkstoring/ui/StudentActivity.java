package com.example.studentmarkstoring.studentmarkstoring.ui;

import android.os.Bundle;

import com.example.studentmarkstoring.R;
import com.example.studentmarkstoring.studentmarkstoring.adapter.StudentAdapter;
import com.example.studentmarkstoring.studentmarkstoring.room.Student;
import com.example.studentmarkstoring.studentmarkstoring.ui.dialog.StudentEntry;
import com.example.studentmarkstoring.studentmarkstoring.viewmodel.StudentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class StudentActivity extends AppCompatActivity {
    private RecyclerView rv_students;
    private StudentAdapter studentAdapter;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rv_students = findViewById(R.id.rv_students);
        FloatingActionButton fab = findViewById(R.id.fab);
        studentAdapter = new StudentAdapter(this);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        rv_students.setLayoutManager(new LinearLayoutManager(this));
        rv_students.setAdapter(studentAdapter);
        studentViewModel.getStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                studentAdapter.setStudentList(students);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                StudentEntry studentEntry = new StudentEntry();
                studentEntry.show(fm,"Student Entry");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
