package com.ws.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.mappers.BookMapper;
import com.ws.pojo.Book;
import com.ws.service.IBookService;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Accessors(chain = true)
@Service
@Slf4j
public class IBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    //新增书籍
    @Override
    public Boolean saveBook(Book book) {
        //大于0是指该操作影响的行数 要大于0才执行
        return bookMapper.insert(book) > 0;
    }



    //分页查询书籍
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<>(currentPage,pageSize);
        bookMapper.selectPage(page,null);
        return page;
    }

    //根据书名查询书籍
    @Override
    public List<Book> getBookByName(String bookName) {
        if (!StringUtils.isBlank(bookName)){
            LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.like(Book::getName , bookName).orderByDesc(Book::getId);
            List<Book> books = bookMapper.selectList(queryWrapper);
            return books;
        }else {
            log.info("书名不能为空！");
            return null;
        }
    }

    //根据书名分页查询
    @Override
    public IPage<Book> getBookByNamePage(String bookName, Integer pageNum, Integer pageSize) {
//        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.like(Book::getName , bookName).orderByDesc(Book::getId);
//        Page<Book> page = new Page<>(pageNum,pageSize);
//        Page<Book> bookPage = bookMapper.selectPage(page, queryWrapper);
//        return bookPage;
        List<Book> bookList = bookMapper.getByBookName(bookName);
        Page<Book> bookPage = new Page<>(pageNum,pageSize);

        return null;
    }

    //根据id更新书籍
    @Override
    public Boolean updateBook(Book book) {
        if(ObjectUtils.isNotEmpty(book) && ObjectUtils.isNotNull(book)){
            int i = bookMapper.updateById(book);
            if( i == 1){
                log.info("更新成功");
                return true;
            }else {
                log.info("更新失败");
                return false;
            }
        }else {
            log.info("传入对象不能为空");
            return false;
        }
    }


    @Override
    public Boolean deleteBookById(Integer id) {
        if (ObjectUtils.isNotNull(id) && ObjectUtils.isNotEmpty(id)){
            int i = bookMapper.deleteById(id);
            if (i == 1){
                log.info("删除成功！");
                return true;
            }else {
                log.info("删除失败！");
                return false;
            }
        }else {
            log.info("传入id不能为空！");
            return false;
        }

    }


}
