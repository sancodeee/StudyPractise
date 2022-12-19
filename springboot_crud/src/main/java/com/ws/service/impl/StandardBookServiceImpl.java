package com.ws.service.impl;

import com.ws.mappers.BookMapper;
import com.ws.pojo.Book;
import com.ws.service.StandardBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardBookServiceImpl implements StandardBookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Boolean add(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Book selectById(Integer id) {
        return bookMapper.selectById(id);
    }


}
