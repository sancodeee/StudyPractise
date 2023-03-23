package com.ws.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.dto.BookWithAuthor;
import com.ws.mapper.BookAuthorMapper;
import com.ws.service.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorServiceImpl extends ServiceImpl<BookAuthorMapper, BookWithAuthor> implements BookAuthorService {

    @Autowired
    private BookAuthorMapper bookAuthorMapper;

    @Override
    public List<BookWithAuthor> getBookByName(String name) {
        List<BookWithAuthor> list = bookAuthorMapper.getBookInfo(name);
        return list;
    }

}
