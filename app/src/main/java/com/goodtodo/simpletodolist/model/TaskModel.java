package com.goodtodo.simpletodolist.model;

/**
 * 待辦事項模型
 */
public class TaskModel {
    /**
     * 標題
     */
    private String taskTitle;
    /**
     * 內容
     */
    private String taskContent;

    /**
     * 建構子
     *
     * @param taskTitle   標題
     * @param taskContent 內容
     */
    public TaskModel(String taskTitle, String taskContent) {
        this.taskTitle = taskTitle;
        this.taskContent = taskContent;
    }

    /**
     * 設定標題
     *
     * @param taskTitle 標題
     */
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    /**
     * 取得標題
     *
     * @return 標題
     */
    public String getTaskTitle() {
        return this.taskTitle;
    }

    /**
     * 設定內容
     *
     * @param taskContent 內容
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    /**
     * 取得內容
     *
     * @return 內容
     */
    public String getTaskContent() {
        return this.taskContent;
    }
}
