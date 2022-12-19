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
    public Result getAll(){
        log.info("查询成功");
        return new Result(true,iBookService.list(),"查询成功！");
    }

    //根据id查询
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Integer id) throws Exception {
        log.info("查询成功！");
        return new Result(true, iBookService.getById(id),"查询成功！");
    }

    //分页查询
    @GetMapping("/getPage/{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        log.info("查询成功！");
        return new Result(true,iBookService.getPage(currentPage, pageSize),"查询成功！");
    }

    //添加
    @PostMapping("/save")
    public Result save(@RequestBody Book book) throws Exception {
//        if(true) {throw new Exception();}
        boolean success = iBookService.save(book);
        return new Result(success,success ? "添加成功！" : "添加失败！");
    }

    //更新操作
    @PutMapping("/update")
    public Result updateById(@RequestBody Book book){
        boolean success = iBookService.updateById(book);
        return new Result(success,success ? "更新成功！" : "更新失败！");
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean success = iBookService.removeById(id);
        return new Result(success,success ? "删除成功！" : "删除失败！");
    }




}
