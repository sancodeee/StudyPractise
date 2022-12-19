package com.ws.service;

import com.ws.pojo.Book;

public interface StandardBookService {

    Boolean add(Book book);
    Boolean deleteById(Integer id);
    Boolean update(Book book);
    Book selectById(Integer id);

}
