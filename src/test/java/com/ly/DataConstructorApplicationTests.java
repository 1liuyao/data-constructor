package com.ly;

import com.ly.mapper.BookMapper2;
import com.ly.mapper.ListMapper;
import com.ly.pojo.Book;
import com.ly.pojo.ListTable;
import com.ly.pojo.RO.RequestStudyCenter;
import com.ly.pojo.TripleResponse.ResponseStudyCenter;
import com.ly.pojo.TripleResponse.ShowListResponse;
import com.ly.pojo.TripleResponse.TripleResponseTemplate;
import com.ly.service.ListService;
import com.ly.utils.JsonUtilsPlus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@SpringBootTest
class DataConstructorApplicationTests {
    @Autowired
    BookMapper2 bookMapper2;
    @Autowired
    Book book2;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TripleResponseTemplate tripleResponseTemplate;

    @Autowired
    ShowListResponse showListResponse;

    @Autowired
    ListService listService;

    @Autowired
    ListMapper listMapper;

    // 发送Get请求，无参数
    @Test
    void restTempLateGet() throws Exception {

        URI url = new URI("https://bapi.gaotu100.com/cms/footerLink/showlist");
        ResponseEntity<TripleResponseTemplate<ShowListResponse>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<TripleResponseTemplate<ShowListResponse>>() {
        });
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity.getBody());
        TripleResponseTemplate<ShowListResponse> body = exchange.getBody();

        ListTable[] list = body.getData().getList();
        for (ListTable l:
             list) {
            System.out.println(l);
        }
    }
    @Test
    void serviceTest(){
        int i = listService.saveGetShowListItems();
        System.out.println(i);
    }

    @Test
    void mapperTestInsert(){
        ListTable listTable = new ListTable();
        listTable.setName("df");
        listTable.setType("d");
        listTable.setIdOrUrl("dof");
        System.out.println(listMapper.insert(listTable));
    }

    // 发送post请求，设置请求头
    @Test
    void postRequestTest() throws Exception {
        URI url = new URI("https://api.gaotu100.com/studyCenter/v1/user/clazz/list");
        RequestStudyCenter request = new RequestStudyCenter();
        request.setPlatformType(0);
        request.setClazzStatus(0);
        request.setSubjectId(0);
        request.setVideoType(0);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json"); // 传递请求体时必须设置
        httpHeaders.add("sid",": 1020408000040c1811ded1054e53d449c1df93fc2c2bf3e0");
        httpHeaders.add("gid", "a19bff24223cf4ea75cb1caf06d6f81d");
        httpHeaders.add("UID", "8126490533394");

        // 设置请求体
        HttpEntity<RequestStudyCenter> requestExchange = new HttpEntity<>(request, httpHeaders);
        // 添加cookies


        ResponseEntity<TripleResponseTemplate<ResponseStudyCenter>> exchange = restTemplate.exchange(url, HttpMethod.POST, requestExchange, new ParameterizedTypeReference<TripleResponseTemplate<ResponseStudyCenter>>() {
        });
        TripleResponseTemplate<ResponseStudyCenter> body = exchange.getBody();
        System.out.println(body.getData());
    }
    @Test
    void postRequestTest1() throws Exception {
        URI url = new URI("https://api.gaotu100.com/studyCenter/v1/user/clazz/list");
        // 设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        httpHeaders.add("sid","1020408000040c1811ded1054e53d449c1df93fc2c2bf3e0");
        httpHeaders.add("gid", "a19bff24223cf4ea75cb1caf06d6f81d");
        httpHeaders.add("UID", "8126490533394");

        // 设置cookies，cookies是一个List ，因为cookie包含多个键值对，但是对应一个键“cookies”，通常响应中对应“set_cookies”
        // cookies:
        //       a : a
        //       b : b
//        httpHeaders.put(HttpHeaders.COOKIE,cookies);

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
            System.out.println(s.getClazzInfo());
        }

    }

}
