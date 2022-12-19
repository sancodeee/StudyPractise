package com.ws.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
