package com.goodtodo.simpletodolist.view;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goodtodo.simpletodolist.R;
import com.goodtodo.simpletodolist.model.TaskModel;
import com.goodtodo.simpletodolist.model.TaskService;

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

        TaskService service = new TaskService(AddTaskActivity.this);
        TaskModel model = new TaskModel(taskTitle, taskContent);
        service.addOne(model);

        Toast.makeText(this, "輸入的標題：" + taskTitle + "\n輸入的內容：" + taskContent, Toast.LENGTH_SHORT).show();
        setResult(Activity.RESULT_OK);
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
