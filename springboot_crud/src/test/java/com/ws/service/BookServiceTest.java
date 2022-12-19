package com.ws.service;

import com.ws.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private StandardBookService standardBookService;

    @Test
    void selectTest(){
        Book book = standardBookService.selectById(5);
        System.out.println(book);
    }

}
