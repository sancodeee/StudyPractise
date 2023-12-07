package com.ws.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.dao.BookMapper;
import com.ws.pojo.Book;
import com.ws.service.IBookService;
import com.ws.vo.BookNameCountVo;
import com.ws.vo.BookVo;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    /**
     * 分页查询书籍
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @return IPage
     */
    @Override
    public IPage<BookVo> getPage(int currentPage, int pageSize) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.between(Book::getId, 10, 50).like(Book::getDescription, "本书").orderByDesc(Book::getId);
        Page<Book> page = new Page<>(currentPage, pageSize);
        IPage<Book> bookPage = bookMapper.selectPage(page, wrapper);
        List<Book> bookList = bookPage.getRecords();
        ArrayList<BookVo> bookVoList = new ArrayList<>();
        for (Book book : bookList) {
            BookVo bookVo = new BookVo();
            BeanUtils.copyProperties(book, bookVo);
            bookVoList.add(bookVo);
        }
        IPage<BookVo> bookVoPage = new Page<>();
        bookVoPage.setRecords(bookVoList)
                .setCurrent(bookPage.getCurrent())
                .setTotal(bookPage.getTotal())
                .setSize(bookPage.getSize())
                .setPages(bookPage.getPages());
        return bookVoPage;
    }

    //根据书名查询书籍
    @Override
    public List<Book> getBookByName(String bookName) {
        if (!StringUtils.isBlank(bookName)) {
            LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.like(Book::getName, bookName).orderByDesc(Book::getId);
            List<Book> books = bookMapper.selectList(queryWrapper);
            return books;
        } else {
            log.info("书名不能为空！");
            return null;
        }
    }

    //根据书名查询该书在数据库中的信息条数
    @Override
    public BookNameCountVo getCountByName(String bookName) {
        if (StringUtils.isNotBlank(bookName)) {
            BookNameCountVo bookNameCountVo = new BookNameCountVo();
            LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Book::getName, bookName);
            Long count = bookMapper.selectCount(wrapper);
            bookNameCountVo.setCount(count);
            bookNameCountVo.setName(bookName);
            return bookNameCountVo;
        }
        return null;
    }


    //根据id查询书籍
    @Override
    public Book getBookById(Integer id) {
        return bookMapper.selectById(id);
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
        Page<Book> bookPage = new Page<>(pageNum, pageSize);

        return null;
    }

    //根据id更新书籍
    @Override
    public Boolean updateBook(Book book) {
        if (ObjectUtils.isNotEmpty(book) && ObjectUtils.isNotNull(book)) {
            int i = bookMapper.updateById(book);
            if (i != 0) {
                log.info("更新成功");
                return true;
            } else {
                log.info("更新失败");
                return false;
            }
        } else {
            log.info("传入对象不能为空");
            return false;
        }
    }

    //根据id删除书籍
    @Override
    public Boolean deleteBookById(Integer id) {
        if (ObjectUtils.isNotNull(id) && ObjectUtils.isNotEmpty(id)) {
            int i = bookMapper.deleteById(id);
            if (i == 1) {
                log.info("删除成功！");
                return true;
            } else {
                log.info("删除失败！");
                return false;
            }
        } else {
            log.info("传入id不能为空！");
            return false;
        }

    }


}
