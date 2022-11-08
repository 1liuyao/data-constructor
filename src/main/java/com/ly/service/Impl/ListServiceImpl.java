package com.ly.service.Impl;

import com.ly.controller.utils.StatusCode;
import com.ly.controller.utils.TripleURL;
import com.ly.mapper.ClazzMapper;
import com.ly.mapper.ListMapper;
import com.ly.pojo.ClassInfo;
import com.ly.pojo.ListTable;
import com.ly.pojo.RO.RequestStudyCenter;
import com.ly.pojo.TripleResponse.ResponseStudyCenter;
import com.ly.pojo.TripleResponse.ShowListResponse;
import com.ly.pojo.TripleResponse.TripleResponseTemplate;
import com.ly.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ListServiceImpl implements ListService {
    @Autowired
    ListMapper listMapper;
    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Boolean save(ListTable listTable) {
        return listMapper.insert(listTable) > 0;
    }

    @Override
    public List<ListTable> getAll() {
        return listMapper.selectList(null);
    }

    // 将get获取的list 批量插入数据库
    @Override
    public int saveGetShowListItems() {
        int result = 0;
        URI url = null;
        try {
            url = new URI(TripleURL.SHOW_LIST_URL.getUrl());
        } catch (URISyntaxException e) {
            throw new RuntimeException(StatusCode.URL_ERROR.getDescription());
        }
        ResponseEntity<TripleResponseTemplate<ShowListResponse>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<TripleResponseTemplate<ShowListResponse>>() {
        });

        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        TripleResponseTemplate<ShowListResponse> body = exchange.getBody();
        ListTable[] list = body.getData().getList();
        for (ListTable l: list) {
            listMapper.insert(l);
            result ++;
        }
        return result;
    }

}
