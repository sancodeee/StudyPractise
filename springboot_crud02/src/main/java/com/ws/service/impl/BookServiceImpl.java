package com.ws.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.entity.Book;
import com.ws.mapper.AuthorMapper;
import com.ws.mapper.BookCompleteWithAutMapper;
import com.ws.mapper.BookMapper;
import com.ws.service.BookService;
import com.ws.vo.BookCompleteVo;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
@Slf4j
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookCompleteWithAutMapper bookCompleteWithAutMapper;

    @Autowired
    private AuthorMapper authorMapper;

    //查询全部数据
    @Override
    @Transactional //开启事务 方法内多个数据库操作 要么全部成功 要么全部失败
    public List<Book> getAllBookList() {
        List<Book> allBookList = bookMapper.selectList(null);
        return allBookList;
    }

    //分页查询全部数据
    public IPage<Book> getAllBookPage(int pageNum, int pageSize) {
        Page<Book> page = new Page<>(pageNum, pageSize);
        Page<Book> bookPage = bookMapper.selectPage(page, null);
        return bookPage;
    }

    //查询全部数据带有作者
    @Override
    @Transactional
    public List<BookCompleteVo> getAllBookWithAuthor() {
        List<Book> bookList = bookMapper.selectList(null);
        ArrayList<BookCompleteVo> BookCompleteList = new ArrayList<>();
        //暴力查询 时间复杂度为 n²
        bookList.forEach(book -> {
            BookCompleteVo bookCompleteVo = new BookCompleteVo();
            BeanUtils.copyProperties(book, bookCompleteVo);
            bookCompleteVo.setAuthorName(authorMapper.selectById(book.getBookAuthor()).getAuthor());
            BookCompleteList.add(bookCompleteVo);
        });
        return BookCompleteList;
    }

    //查询全部数据带有作者：方法二：使用sql语句进行多表联查
    public List<BookCompleteVo> getAllBookWithAuthor2() {
        List<BookCompleteVo> allBookWithAuthor = bookCompleteWithAutMapper.getAllBookWithAuthor();
        return allBookWithAuthor;
    }

    //根据书名查询
    @Override
    public List<BookCompleteVo> getBookByName(String name) {
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Book::getName, name);
        ArrayList<BookCompleteVo> bookCompleteList = new ArrayList<>();
        if (StringUtils.isNotBlank(name)) {
            List<Book> bookList = bookMapper.selectList(queryWrapper);
            bookList.forEach(book -> {
                BookCompleteVo bookCompleteVo = new BookCompleteVo();
                BeanUtils.copyProperties(book, bookCompleteVo);
                bookCompleteVo.setAuthorName(authorMapper.selectById(book.getBookAuthor()).getAuthor());
                bookCompleteList.add(bookCompleteVo);
            });
        }
        return bookCompleteList;
    }

    //根据书名查询 ： sql连表查询
    public List<BookCompleteVo> getBookByName2(String name){
        return bookCompleteWithAutMapper.getBookByName(name);
    }


}
