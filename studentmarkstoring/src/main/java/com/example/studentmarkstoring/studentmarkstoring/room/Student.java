package com.example.studentmarkstoring.studentmarkstoring.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "IT_Table")
public class Student {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "RollNo")
    public int mRollNo;

    @ColumnInfo(name = "Name")
    public String mName;

    @ColumnInfo(name = "Subject")
    public String mSubject;

    @ColumnInfo(name = "Mark")
    public int mMark;



    public int getmRollNo() {
        return mRollNo;
    }

    public void setmRollNo(int mRollNo) {
        this.mRollNo = mRollNo;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSubject() {
        return mSubject;
    }

    public void setmSubject(String msubject) {
        this.mSubject = msubject;
    }

    public int getmMark() {
        return mMark;
    }

    public void setmMark(int mMark) {
        this.mMark = mMark;
    }
}
