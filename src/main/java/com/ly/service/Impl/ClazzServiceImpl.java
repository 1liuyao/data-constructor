package com.ly.service.Impl;

import com.ly.controller.utils.StatusCode;
import com.ly.controller.utils.TripleURL;
import com.ly.mapper.ClazzMapper;
import com.ly.pojo.ClassInfo;
import com.ly.pojo.RO.RequestStudyCenter;
import com.ly.pojo.TripleResponse.ResponseStudyCenter;
import com.ly.pojo.TripleResponse.TripleResponseTemplate;
import com.ly.service.CLazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ClazzServiceImpl implements CLazzService {
    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Boolean savePostResponse(ClassInfo classInfo) {
        return clazzMapper.insert(classInfo) > 0;
    }

    @Override
    public List<ClassInfo> getAllClazzInfo() {
        return clazzMapper.selectList(null);
    }
    @Override
    public int savePostClazzList() {
        // 确认请求路径
        URI url = null;
        int result = 0;
        try {
            url = new URI(TripleURL.Clazz_LIST_URL.getUrl());
        } catch (URISyntaxException e) {
            throw new RuntimeException(StatusCode.URL_ERROR.getDescription());
        }
        // 设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        // 登录过期则失效
        httpHeaders.add("sid","1020408000040c1811ded1054e53d449c1df93fc2c2bf3e0");
        httpHeaders.add("gid", "a19bff24223cf4ea75cb1caf06d6f81d");
        httpHeaders.add("UID", "8126490533394");

        // 设置请求体
        RequestStudyCenter request = new RequestStudyCenter();
        request.setPlatformType(0);
        request.setClazzStatus(0);
        request.setSubjectId(0);
        request.setVideoType(0);

        // 封装HttpClient
        HttpEntity<RequestStudyCenter> stringHttpEntity = new HttpEntity<>(request, httpHeaders);

        ResponseEntity<TripleResponseTemplate<ResponseStudyCenter>> exchange = restTemplate.exchange(url, HttpMethod.POST, stringHttpEntity, new ParameterizedTypeReference<TripleResponseTemplate<ResponseStudyCenter>>() {
        });
        TripleResponseTemplate<ResponseStudyCenter> body = exchange.getBody();
        List<ResponseStudyCenter.FinishedClazzPageBean.FinishedClazzListBean> finishedClazzList = body.getData().getFinishedClazzPage().getFinishedClazzList();
        for (ResponseStudyCenter.FinishedClazzPageBean.FinishedClazzListBean s:
                finishedClazzList) {
            ClassInfo clazzInfo = s.getClazzInfo();
            savePostResponse(clazzInfo);
            result++;
        }

        return result;
    }
}
