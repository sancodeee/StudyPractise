package com.ws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

    List<Book> getByBookName(@Param(value = "bookName") String bookName);

}
