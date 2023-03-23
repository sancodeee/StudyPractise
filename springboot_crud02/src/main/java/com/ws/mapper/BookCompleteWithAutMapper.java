package com.ws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.vo.BookCompleteVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookCompleteWithAutMapper extends BaseMapper<BookCompleteVo> {

    //查询全部数据带有作者 : 利用sql进行多表联查
    List<BookCompleteVo> getAllBookWithAuthor();

    //根据书名查询
    List<BookCompleteVo> getBookByName(@Param(value = "name") String name);

    //根据书名和书籍类型查询
    List<BookCompleteVo> getBookByNameAndType(@Param(value = "name") String name , @Param(value = "type") String type);
}
