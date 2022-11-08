package com.ly.pojo.TripleResponse;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class ListTableCopy {
    Integer type;
    String name;
    String idOrUrl;
}
