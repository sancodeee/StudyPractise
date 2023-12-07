package com.ws.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.dto.BookWithAuthor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookAuthorMapper extends BaseMapper<BookWithAuthor> {

    List<BookWithAuthor> getBookInfo(@Param(value = "name") String name);

}
