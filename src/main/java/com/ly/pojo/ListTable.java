package com.ly.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
@TableName("list")
public class ListTable {
    @TableId
    private Integer id;
    private String type;
    private String name;
    @TableField("id_or_url")
    private String idOrUrl;
}
