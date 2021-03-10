package com.example.gradeviewer;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Course  {

    private static int courseID = 0;
    private String courseTitle;
    private ArrayList<Assignment> assignments;
    private int avgGrade;

    private Course(String courseTitle, ArrayList<Assignment> assignments, int avgGrade) {
        this.courseTitle = courseTitle;
        this.assignments = assignments;
        this.avgGrade = avgGrade;
        this.courseID++;
    }

    // Generate assignments for A course and calculate Average of the course
    static public Course generateRandomCourse(){
        Random rnd = new Random();
        int assignmentNo = rnd.nextInt(5);
        ArrayList<Assignment> tempAssigns = new ArrayList<Assignment>();
        int tempAvg = 0;

        for (int i = 1; i <= assignmentNo ; i++)
            tempAssigns.add(Assignment.generateRandomAssignment(i));

        for (int j = 0; j< tempAssigns.size(); j++)
            tempAvg += tempAssigns.get(j).getAssignmentGrade();

        // Prevent divide by 0
        tempAvg = tempAvg / (tempAssigns.size() == 0 ? 1 : tempAssigns.size());

        return new Course("Course " + courseID, tempAssigns, tempAvg);
    }

    // Generate an array containing N course
    public static ArrayList<Course> generateRandom_n_Course(int numberOfCourse) {
        ArrayList<Course> coursesTemp = new ArrayList<>();
        Random rnd = new Random();
        int randomNumberOfCourse = rnd.nextInt(numberOfCourse) + 1;

        for (int k = 0; k<randomNumberOfCourse; k++){
            Course courseSingle = Course.generateRandomCourse();
            coursesTemp.add(courseSingle);
        }

        courseID = 1;
        return coursesTemp;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public int getAvgGrade() {
        return avgGrade;
    }
}

