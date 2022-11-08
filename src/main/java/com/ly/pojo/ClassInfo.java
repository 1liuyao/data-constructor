package com.ly.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
@TableName("tbl_class_info")
public class ClassInfo {
    @TableId
    private Integer id;
    @TableField("clazz_number")
    private String clazzNumber;
    @TableField("sub_clazz_number")
    private String subClazzNumber;
    @TableField("clazz_name")
    private String clazzName;
    private String subject;
}
