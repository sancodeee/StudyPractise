package com.ws.controller;

import com.ws.controller.result.Result;
import com.ws.pojo.Book;
import com.ws.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    //查询全部
    @GetMapping("/queryAll")
    public Result getAll(){
        log.info("查询成功");
        return Result.queryOk(iBookService.list());
    }

    //根据id查询
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Integer id) throws Exception {
        log.info("查询成功！");
        Book book = iBookService.getById(id);
        return Result.queryOk(book);
    }

    @GetMapping("/getPage/{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        log.info("查询成功！");
        return Result.queryOk(iBookService.getPage(currentPage, pageSize));
    }

    //添加
    @PostMapping("/save")
    public Result save(@RequestBody Book book) throws Exception {
//        if(true) {throw new Exception();}
        boolean success = iBookService.save(book);
        return Result.insertOk();
    }

//    //更新操作
//    @PutMapping("/update")
//    public Result updateById(@RequestBody Book book){
//        boolean success = iBookService.updateById(book);
//        return new Result(success,success ? "更新成功！" : "更新失败！","");
//    }
//
//    //删除
//    @DeleteMapping("/delete/{id}")
//    public Result deleteById(@PathVariable Integer id){
//        boolean success = iBookService.removeById(id);
//        return new Result(success,success ? "删除成功！" : "删除失败！","");
//    }




}
