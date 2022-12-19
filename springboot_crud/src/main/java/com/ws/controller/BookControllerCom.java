package com.ws.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ws.logger.LogFactory;
import com.ws.pojo.Book;
import com.ws.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//继承自己写的 生产日志类对象 的类 ，实现日志功能
//@RestController
@RequestMapping("/books")
public class BookControllerCom extends LogFactory {

    @Autowired
    private IBookService iBookService;

    //查询全部
    @GetMapping("/queryAll")
    public List<Book> getAll(){
        List<Book> list = iBookService.list();
        return list;
    }

    //根据id查询
    @GetMapping("/getById/{id}")
    public Book getById(@PathVariable Integer id){
        Book book = iBookService.getById(id);
        return book;
    }

    //分页查询
    @GetMapping("/getPage/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        IPage<Book> page = iBookService.getPage(currentPage, pageSize);
        return page;
    }

    //添加
    @PostMapping("/save")
    public Boolean save(@RequestBody Book book){
        boolean b = iBookService.save(book);
        return b;
    }

    //更新操作
    @PutMapping("/update")
    public Boolean updateById(@RequestBody Book book){
        return iBookService.updateById(book);
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Boolean deleteById(@PathVariable Integer id){
        return iBookService.removeById(id);
    }





}
