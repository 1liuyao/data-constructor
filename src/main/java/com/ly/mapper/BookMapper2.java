package com.ly.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper2 extends BaseMapper<Book>{

    // @Select("select * from tbl_book where id = #{id}")
    Book getById1(int id);
    List<Book> selectAll1();
    List<Book> selectByCondition1(@Param("name") String name, @Param("type") String type);
    // @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int add1(Book book2);
}