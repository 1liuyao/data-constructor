package com.ly.service;

import com.ly.pojo.ClassInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CLazzService {
    Boolean savePostResponse(ClassInfo classInfo);
    List<ClassInfo> getAllClazzInfo();
    int savePostClazzList();
}
