package com.goodtodo.simpletodolist.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goodtodo.simpletodolist.R;
import com.goodtodo.simpletodolist.model.TaskModel;
import com.goodtodo.simpletodolist.model.TaskService;

public class EditTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
    }

    /**
     * 編輯待辦事項
     * @param v
     */
    public void editTask(View v) {
        String taskTitle = ((TextView)findViewById(R.id.taskTitle)).getText().toString();
        String taskContent = ((TextView)findViewById(R.id.taskContent)).getText().toString();
        TaskModel model = new TaskModel(taskTitle, taskContent);

        TaskService service = new TaskService(EditTaskActivity.this);
        service.update(model);

        Toast.makeText(this, "輸入的標題：" + taskTitle + "\n輸入的內容：" + taskContent, Toast.LENGTH_SHORT).show();
        finish();
    }

    /**
     * 關閉編輯待辦事項頁面
     * @param v
     */
    public void closeEditTaskView(View v) {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }
}
