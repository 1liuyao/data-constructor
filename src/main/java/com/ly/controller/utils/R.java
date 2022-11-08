package com.ly.controller.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author CandyWall
 * @Date 2022/1/20--13:50
 * @Description 发给前端的统一数据格式，规范化后端响应格式
 */
@Data
@NoArgsConstructor
public class R {
    private String code;
    private Object data;
    private String msg;

    public R(String code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public R(String msg) {
        this.msg = msg;
    }

    public R(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
