package com.ws.testDemo;

import com.ws.pojo.Book;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@Accessors(chain = true)
@SpringBootTest
public class MongodbTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void insert(){

        Book book = new Book().setName("Mongodb").setId(5).setType("book").setDescription("非常好的书");
        mongoTemplate.insert(book);

    }



}
