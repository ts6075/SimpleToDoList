package com.goodtodo.simpletodolist.model;

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

public class TaskService {
    private final SQLiteDatabase db;

    public TaskService(SQLiteDatabase db) {
        this.db = db;
        db.execSQL("CREATE TABLE IF NOT EXISTS Tasks(Id INTEGER PRIMARY KEY AUTOINCREMENT , TaskTitle TEXT, TaskContent TEXT);");
    }

    public void add() {
        db.execSQL("INSERT INTO Tasks (TaskTitle, TaskContent) VALUES('test', 'test');");
    }

    public void getOne() {

    }

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

        model.add(new TaskModel("test", "test"));
        Log.d("tS","test");
        return model;
    }

    public void update() {

    }

    public void delete() {

    }
}
