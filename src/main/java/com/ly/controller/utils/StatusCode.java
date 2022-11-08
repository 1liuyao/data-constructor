package com.ly.controller.utils;

public enum StatusCode {
    OK ("200","状态正常"),
    INSERT_RIGHT ("1000","插入成功"),
    INSERT_ERROR ("1001","插入失败"),
    DELETE_RIGHT ("2000","删除成功"),
    DELELE_ERROR ("2001","删除失败"),
    PUT_RIGHT ("3000","更新成功"),
    PUT_ERROR ("3001","更新失败"),
    SELECT_RIGHT ("4000","查询成功"),
    SELECT_ERROR ("4001","查询失败"),
    URL_ERROR ("5001","url拼接错误");

    private final String code;
    private final String description;

    private StatusCode(String code, String description){
        this.code = code;
        this.description = description;
    }


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
