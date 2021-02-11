package com.goodtodo.simpletodolist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.goodtodo.simpletodolist.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView taskListView = findViewById(R.id.taskListView);
        ListAdapter taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new String[]{"1", "2"});
        taskListView.setAdapter(taskAdapter);
    }

    public void goToAddTaskView(View v) {
        Intent intentMain = new Intent(MainActivity.this, AddTaskActivity.class);
        startActivityForResult(intentMain, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String title = data.getStringExtra("title");
                String txt = data.getStringExtra("txt");
                String date = data.getStringExtra("date");
                String delete = data.getStringExtra("delete");
                String category = data.getStringExtra("categorie");
                SimpleDateFormat newDateFormat = new SimpleDateFormat("EE d MMM yyyy k:m");
                Date d = null;
                try {
                    d = newDateFormat.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (data.getStringExtra("edit").equals("true")) {
                } else {
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //here goes nothing
            }
        }
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }
}