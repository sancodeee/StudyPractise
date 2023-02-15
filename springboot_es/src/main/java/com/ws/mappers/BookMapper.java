package com.ws.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface BookMapper extends BaseMapper<Book> {

    List<Book> getBookByType(@Param(value = "type") String type);
}
