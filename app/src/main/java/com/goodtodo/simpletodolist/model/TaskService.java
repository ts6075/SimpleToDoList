package com.goodtodo.simpletodolist.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 待辦事項服務
 */
public class TaskService {
    private final SQLiteDatabase db;

    /**
     * 建構子
     * @param context
     */
    public TaskService(Context context) {
        this.db = context.openOrCreateDatabase("todolist", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Tasks(Id INTEGER PRIMARY KEY AUTOINCREMENT , TaskTitle TEXT, TaskContent TEXT);");
    }

    /**
     * 新增
     * @param model
     */
    public void addOne(TaskModel model) {
        db.execSQL("INSERT INTO Tasks (TaskTitle, TaskContent) VALUES('" + model.getTaskTitle() + "', '" + model.getTaskContent() + "');");
    }

    /**
     * 取得單一資料
     */
    public TaskModel getOne(TaskModel model) {
        Cursor resultSet = db.rawQuery("SELECT TOP 1 * FROM Tasks WHERE Id = " + model.getTaskId(), null);
        resultSet.moveToFirst();
        TaskModel data = new TaskModel(
                resultSet.getInt(resultSet.getColumnIndex("Id")),
                resultSet.getString(resultSet.getColumnIndex("TaskTitle")),
                resultSet.getString(resultSet.getColumnIndex("TaskContent"))
        );
        return data;
    }

    /**
     * 取得列表
     * @return
     */
    public List<TaskModel> getList() {
        List<TaskModel> model = new ArrayList<>();

        Cursor resultSet = db.rawQuery("SELECT * FROM Tasks;", null);
        resultSet.moveToFirst();
        for (int i = 0; i < resultSet.getCount(); i++) {
            TaskModel data = new TaskModel(
                    resultSet.getString(resultSet.getColumnIndex("TaskTitle")),
                    resultSet.getString(resultSet.getColumnIndex("TaskContent"))
            );
            model.add(data);
            resultSet.moveToNext();
        }
        return model;
    }

    /**
     * 更新
     */
    public void update() {

    }

    /**
     * 刪除
     */
    public void delete() {

    }
}
