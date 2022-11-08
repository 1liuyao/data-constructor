package com.ly.pojo.TripleResponse;

import com.ly.pojo.ListTable;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Data
public class ShowListResponse {
    //private String updateTimestamp;
    private ListTable[] list;
}
