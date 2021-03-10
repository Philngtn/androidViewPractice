package com.example.gradeviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class gradeActivity extends AppCompatActivity {

    private boolean isNumber = true;
    private ListView courseListView;
    private courseListViewAdapter adapter;

    // Generate n course
    private ArrayList<Course> courses = Course.generateRandom_n_Course(5);


    // Add the menu item on App bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grade_menu, menu);
        return true;
    }

    // Check click on item on app bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.letter_grade:
                isNumber = !isNumber;
                courseListView = findViewById(R.id.courseListView);
                adapter = new courseListViewAdapter(this, R.layout.course_list_item, courses, isNumber);
                courseListView.setAdapter(adapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Back button
        setContentView(R.layout.activity_grade);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        // ListView ID
        courseListView = findViewById(R.id.courseListView);
        // Setup Adapter for the listView
        adapter = new courseListViewAdapter(this, R.layout.course_list_item, courses, isNumber);
        courseListView.setAdapter(adapter);

    }
}