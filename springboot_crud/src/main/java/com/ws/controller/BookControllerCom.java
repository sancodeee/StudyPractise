package com.ws.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ws.logger.LogFactory;
import com.ws.pojo.Book;
import com.ws.service.IBookService;
import com.ws.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 继承自己写的 生产日志类对象 的类 ，实现日志功能
 */
@RestController
@RequestMapping("/books2")
public class BookControllerCom extends LogFactory {

    @Autowired
    private IBookService iBookService;

    /**
     * 查询全部
     *
     * @return List
     */
    @GetMapping("/queryAll")
    public List<Book> getAll() {
        List<Book> list = iBookService.list();
        return list;
    }

    /**
     * 根据id查询
     *
     * @param id id
     * @return Book
     */
    @GetMapping("/getById/{id}")
    public Book getById(@PathVariable Integer id) {
        Book book = iBookService.getById(id);
        return book;
    }

    /**
     * 分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @return BookVo
     */
    @GetMapping("/getPage/{currentPage}/{pageSize}")
    public IPage<BookVo> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return iBookService.getPage(currentPage, pageSize);
    }

    /**
     * 添加
     *
     * @param book Book实体类
     * @return Boolean
     */
    @PostMapping("/save")
    public Boolean save(@RequestBody Book book) {
        return iBookService.save(book);
    }

    /**
     * 更新操作
     *
     * @param book Book
     * @return Boolean
     */
    @PutMapping("/update")
    public Boolean updateById(@RequestBody Book book) {
        return iBookService.updateById(book);
    }

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    @DeleteMapping("/delete/{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        return iBookService.removeById(id);
    }


}
