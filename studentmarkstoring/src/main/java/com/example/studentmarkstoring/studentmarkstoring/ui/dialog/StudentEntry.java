package com.example.studentmarkstoring.studentmarkstoring.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.studentmarkstoring.R;
import com.example.studentmarkstoring.studentmarkstoring.room.Student;
import com.example.studentmarkstoring.studentmarkstoring.viewmodel.StudentViewModel;

public class StudentEntry extends DialogFragment {
    private View view;
    private EditText ev_name;
    private EditText ev_rollNo;
    private EditText ev_subject;
    private EditText ev_mark;
    private Button btn_submit;
    private StudentViewModel studentViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.student_entry_dialog,container,false);
        getDialog().setCanceledOnTouchOutside(true);
        ev_name = view.findViewById(R.id.ev_name);
        ev_rollNo = view.findViewById(R.id.ev_rollNo);
        ev_subject = view.findViewById(R.id.ev_subject);
        ev_mark = view.findViewById(R.id.ev_mark);
        btn_submit = view.findViewById(R.id.btn_submit);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student();
                student.setmName(ev_name.getText().toString());
                student.setmMark(Integer.parseInt(ev_mark.getText().toString()));
                student.setmSubject(ev_subject.getText().toString());
                student.setmRollNo(Integer.parseInt(ev_rollNo.getText().toString()));
                studentViewModel.insertStudents(student);
                getDialog().dismiss();
            }
        });
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return super.onCreateDialog(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if(dialog !=null){
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width,height);
        }
    }
}
