package com.ly.controller;

import com.ly.controller.utils.R;
import com.ly.controller.utils.StatusCode;
import com.ly.pojo.ClassInfo;
import com.ly.service.CLazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    CLazzService cLazzService;

    @GetMapping("/list")
    public R getClazzList(){
        List<ClassInfo> allClazzInfo = cLazzService.getAllClazzInfo();
        return new R(StatusCode.SELECT_RIGHT.getCode(), allClazzInfo, StatusCode.SELECT_RIGHT.getDescription());
    }
    @GetMapping("/saveTripleData")
    public R saveTripleData(){
        int i = cLazzService.savePostClazzList();
        if (i < 0){
            return new R(StatusCode.INSERT_RIGHT.getDescription());
        }
        return new R(StatusCode.INSERT_RIGHT.getCode(), i,"访问第三方接口并入库成功");
    }

    @PostMapping
    public R save(@RequestBody ClassInfo classInfo) {
        boolean flag = cLazzService.savePostResponse(classInfo);
        if (!flag)
            return new R(StatusCode.INSERT_ERROR.getCode(),StatusCode.INSERT_ERROR.getDescription());
        return new R(StatusCode.INSERT_RIGHT.getCode(),StatusCode.INSERT_RIGHT.getDescription());
    }
}
