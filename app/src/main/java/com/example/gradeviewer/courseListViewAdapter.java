package com.example.gradeviewer;

import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class courseListViewAdapter extends ArrayAdapter<Course> {

    private Context mContext;
    int mResource;
    boolean misNumber;

    public courseListViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Course> objects, boolean isNumber) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        misNumber = isNumber;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get data from Course ArrayList by position (location)
        String courseName = getItem(position).getCourseTitle();
        int courseAvg = getItem(position).getAvgGrade();
        ArrayList<Assignment> assignmentArrayList = getItem(position).getAssignments();


        // Setup Layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);


        // Get ID from custom layout
        TextView courseNameLayout = (TextView) convertView.findViewById(R.id.courseName);
        TextView courseAvgLayout = (TextView) convertView.findViewById(R.id.courseAvg);
        LinearLayout assignmentListLayout = (LinearLayout) convertView.findViewById(R.id.assignList);
        LinearLayout assignmentGradeListLayout = (LinearLayout) convertView.findViewById(R.id.assignGradeList);

        // Set data to custom layout
        courseNameLayout.setText(courseName);
        // Modify to LETTER or NUMBER
        if (misNumber) {
            courseAvgLayout.setText("Average: " + courseAvg);
        } else {
            courseAvgLayout.setText("Average: " + toLetter.gradeToLetter(courseAvg));
        }

        if (assignmentArrayList.size() == 0) {
            TextView temp = new TextView(parent.getContext());
            temp.setText("No assignment for this course.");
            assignmentListLayout.addView(temp);
            courseAvgLayout.setText("Average: ~");
        }

        for (int i = 0 ; i < assignmentArrayList.size(); i++){

            // Generate Temporary TextView to add to the Linear Layout
            TextView temp = new TextView(parent.getContext());
            TextView temp2 = new TextView(parent.getContext());
            temp2.setGravity(Gravity.END);


            temp.setText(assignmentArrayList.get(i).getAssignmentTitle());

            // Modify to LETTER or NUMBER
            if (misNumber)
                temp2.setText(""+assignmentArrayList.get(i).getAssignmentGrade());
            else
                temp2.setText(toLetter.gradeToLetter(assignmentArrayList.get(i).getAssignmentGrade()));

            assignmentGradeListLayout.addView(temp2);
            assignmentListLayout.addView(temp);
        }

        return convertView;
    }
}
