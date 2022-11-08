package com.ly.service;

import com.ly.pojo.ClassInfo;
import com.ly.pojo.ListTable;

import java.util.List;


public interface ListService {
    Boolean save(ListTable listTable);
    List<ListTable> getAll();
    int saveGetShowListItems();

}
