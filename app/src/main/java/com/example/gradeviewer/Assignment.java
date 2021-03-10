package com.example.gradeviewer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class Assignment  {

    private String assignmentTitle;
    private int assignmentGrade;

    private Assignment(String assignmentTitle, int assignmentGrade) {
        this.assignmentTitle = assignmentTitle;
        this.assignmentGrade = assignmentGrade;

    }

    static public Assignment generateRandomAssignment(int assID){
        Random rnd = new Random();
        String tempTitle = "Assignment " + assID;
        int tempGrade = rnd.nextInt(100) + 1;

        return new Assignment(tempTitle, tempGrade);
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public int getAssignmentGrade() {
        return assignmentGrade;
    }

}
