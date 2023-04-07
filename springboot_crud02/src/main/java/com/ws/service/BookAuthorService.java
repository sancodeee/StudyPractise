package com.ws.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.dto.BookWithAuthor;

import java.util.List;

public interface BookAuthorService extends IService<BookWithAuthor> {

    List<BookWithAuthor> getBookByName(String name);

    List<BookWithAuthor> getBookByName2(String name);

}
