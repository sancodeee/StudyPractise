package com.ws.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.entity.Book;
import com.ws.vo.BookCompleteVo;

import java.util.List;

public interface BookService extends IService<Book> {

    //查询全部数据
    List<Book> getAllBookList();

    //分页查询全部数据
    IPage<Book> getAllBookPage(int pageNum, int pageSize);

    //查询全部数据（多表）
    List<BookCompleteVo> getAllBookWithAuthor();
    //方法二
    List<BookCompleteVo> getAllBookWithAuthor2();

    List<BookCompleteVo> getBookByName(String name);

    List<BookCompleteVo> getBookByName2(String name);

}
