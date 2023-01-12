package com.ws.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.entity.Book;
import com.ws.mapper.BookMapper;
import com.ws.service.BookService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    //循环list插入数据
    @Override
    public boolean insertData(List<Book> list) {
        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            bookMapper.insert(book);
        }
        return true;
    }
}
