package com.ws.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ws.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class IBookServiceTest {

    @Autowired
    private IBookService iBookService;

    @Test
    void select(){
        Book book = iBookService.getById(5);
        System.out.println(book);
    }

    @Test
    void selectAll(){
        List<Book> list = iBookService.list();
        System.out.println(list);
    }

    @Test
    void getPage(){
        IPage<Book> page = new Page<>(1,6);
        iBookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());

    }

    @Test
    void saveTest(){
        Book book = new Book();
//        book.setId(7);
        book.setName("在细雨中呼喊");
        book.setType("_doc");
        book.setDescription("本书描述了钢铁是怎样炼成的，描述了钢铁，是怎么炼成的");
        iBookService.saveBook(book);
    }

    @Test
    void getById(){
        Book book = iBookService.getById(4);
        System.out.println(book);
    }


}
