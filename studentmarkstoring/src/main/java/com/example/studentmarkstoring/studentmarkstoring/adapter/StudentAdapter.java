package com.example.studentmarkstoring.studentmarkstoring.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentmarkstoring.R;
import com.example.studentmarkstoring.studentmarkstoring.room.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private Context context;
    private List<Student> studentList = new ArrayList<>();

    public StudentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.student_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_student_Name.setText(studentList.get(position).getmName());
        holder.tv_rollNo.setText(studentList.get(position).getmRollNo()+"");
        holder.tv_subject.setText(studentList.get(position).getmSubject());
        holder.tv_mark.setText(studentList.get(position).getmMark()+"");
    }

    public void setStudentList(List<Student> studentList){
        this.studentList = studentList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_student_Name;
        TextView tv_rollNo;
        TextView tv_subject;
        TextView tv_mark;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_student_Name = itemView.findViewById(R.id.tv_student_Name);
            tv_rollNo = itemView.findViewById(R.id.tv_rollNo);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_mark = itemView.findViewById(R.id.tv_mark);
        }
    }
}
