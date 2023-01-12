package com.ws.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.ws.entity.Book;
import com.ws.listener.BookListener;
import com.ws.listener.BookListenerV2;
import com.ws.result.ResponseResult;
import com.ws.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ReadAndWriteController {

    @Autowired
    private BookService bookService;

    //下载excel接口
    @GetMapping("/book/download")
    public ResponseResult downloadExcel(){

        String PATH = "C:\\Users\\wangsen\\Desktop\\书籍信息下载文件";

        List<Book> bookList = bookService.list();

        EasyExcel.write(PATH + ".xlsx" , Book.class)
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                    .sheet(0,"书籍信息").doWrite(bookList);

        return new ResponseResult(200,true,"下载成功",bookList);
    }

    //读去excel接口
    @PostMapping("/book/read")
    public ResponseResult readExcel(@RequestPart("file") MultipartFile file) throws IOException {
        //基于监听器的读取实现
        EasyExcel.read(file.getInputStream(),Book.class,new BookListener(bookService)).sheet("书籍信息").headRowNumber(2).doRead();

        return new ResponseResult(200,true,"读取成功");
    }

    @PostMapping("/book/readv2")
    public ResponseResult readExcelV2(@RequestPart("file") MultipartFile file) throws IOException{
        //不创建实体对象的读取
        EasyExcel.read(file.getInputStream(),new BookListenerV2()).sheet().headRowNumber(2).doRead();
        return new ResponseResult(200,true,"读取成功");
    }


}
