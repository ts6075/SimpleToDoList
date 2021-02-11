package com.goodtodo.simpletodolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    /**
     * 新增待辦事項
     * @param v
     */
    public void addTask(View v) {
        String taskTitle = ((TextView)findViewById(R.id.taskTitle)).getText().toString();
        String taskContent = ((TextView)findViewById(R.id.taskContent)).getText().toString();
        Toast.makeText(this, "輸入的標題：" + taskTitle + "\n輸入的內容：" + taskContent, Toast.LENGTH_SHORT).show();
        finish();
    }

    /**
     * 關閉新增待辦事項頁面
     * @param v
     */
    public void closeAddTaskView(View v) {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }
}
