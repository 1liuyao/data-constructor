package com.ly.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ly.controller.utils.R;
import com.ly.controller.utils.StatusCode;
import com.ly.mapper.ListMapper;
import com.ly.pojo.ListTable;
import com.ly.service.ListService;
import com.ly.utils.JsonUtilsPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExersiceController {
    @Autowired
    ListService listService;

    @GetMapping("/getAllList")
    public R getAllList(){
        // 将获取的数据保存入库后，在返回结果
        listService.saveGetShowListItems();
        // 直接返回列表信息
        List<ListTable> all = listService.getAll();
        // 将结果组装成 键为”list“ ，值为all的结构
        return new R(StatusCode.SELECT_RIGHT.getCode(), all,StatusCode.SELECT_RIGHT.getDescription());
    }

}
