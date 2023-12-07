package com.ws.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.dto.BookWithAuthor;
import com.ws.entity.Author;
import com.ws.entity.Book;
import com.ws.dao.AuthorMapper;
import com.ws.dao.BookAuthorMapper;
import com.ws.dao.BookCompleteWithAutMapper;
import com.ws.dao.BookMapper;
import com.ws.service.BookAuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookAuthorServiceImpl extends ServiceImpl<BookAuthorMapper, BookWithAuthor> implements BookAuthorService {

    @Autowired
    private BookAuthorMapper bookAuthorMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private BookCompleteWithAutMapper bookCompleteWithAutMapper;


    //方式一：sql
    @Transactional
    @Override
    public List<BookWithAuthor> getBookByName(String name) {
        List<BookWithAuthor> list = bookAuthorMapper.getBookInfo(name);
        return list;
    }

    //方式二：业务逻辑
    @Transactional
    @Override
    public List<BookWithAuthor> getBookByName2(String name) {
        if (StringUtils.isNotBlank(name)) {
            LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Book::getName, name);
            List<Book> bookList = bookMapper.selectList(queryWrapper);
            ArrayList<BookWithAuthor> bookAuthorList = new ArrayList<>();
            bookList.forEach(book -> {
                BookWithAuthor bookWithAuthor = new BookWithAuthor();
                Author author = authorMapper.selectById(book.getBookAuthor());
                log.info("作者信息：{}", author);
                bookWithAuthor.setAuthor(author);
                BeanUtils.copyProperties(book, bookWithAuthor);
                bookAuthorList.add(bookWithAuthor);
            });
            return bookAuthorList;
        } else {
            return null;
        }
    }
}
