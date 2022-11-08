package com.ly.pojo.TripleResponse;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class TripleResponseTemplate<T> {
    private String code;
    private T Data;

    public void setData(T data) {
        Data = data;
    }

    public T getData() {
        return Data;
    }
}
