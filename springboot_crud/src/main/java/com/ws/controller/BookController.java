package com.ws.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ws.controller.result.Result;
import com.ws.pojo.Book;
import com.ws.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    //查询全部
    @GetMapping("/queryAll")
    public Result<List<Book>> getAll(){
        log.info("查询成功");
        return Result.queryOk(iBookService.list());
    }

    //根据id查询
    @GetMapping("/getById/{id}")
    public Result<Book> getById(@PathVariable Integer id) throws Exception {
        log.info("查询成功！");
        Book book = iBookService.getById(id);
        return Result.queryOk(book);
    }

    //根据书名查询
    @GetMapping("/getByName")
    public Result<List<Book>> getByName(@RequestParam(name = "bookName" , required = false , defaultValue = "老人与海") String bookName){
        List<Book> bookList = iBookService.getBookByName(bookName);
        return Result.queryOk(bookList);
    }

    //根据书名分页查询
    @GetMapping("/getByNamePage")
    public Result<IPage<Book>> getByNamePage(@RequestParam(name = "bookName" , required = false , defaultValue = "狂人日记") String bookName,
                                             @RequestParam(name = "pageNum" , required = false , defaultValue = "1") Integer pageNum ,
                                             @RequestParam(name = "pageSize" ,required = false , defaultValue = "5")Integer pageSize){
        IPage<Book> bookByNamePage = iBookService.getBookByNamePage(bookName, pageNum, pageSize);
        return Result.queryOk(bookByNamePage);
    }

    //分页查询全部
    @GetMapping("/getPage/{currentPage}/{pageSize}")
    public Result<IPage<Book>> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        log.info("查询成功！");
        return Result.queryOk(iBookService.getPage(currentPage, pageSize));
    }

    //添加
    @PostMapping("/save")
    public Result<Book> save(@RequestBody Book book) {
        boolean success = iBookService.save(book);
        return Result.insertOk(book);
    }

    //更新
    @PostMapping("/update")
    public Result<Book> update(@RequestBody Book book){
        Boolean updateBook = iBookService.updateBook(book);
        return Result.updateOk(book);
    }

    @GetMapping("/delete")
    public Result<Book> delete(@RequestParam(name = "id" ,required = true) Integer id){
        Boolean book = iBookService.deleteBookById(id);
        if(book == true){
            return Result.deleteOk(id);
        }else {
            return Result.deleteFail(id);
        }
    }





}
