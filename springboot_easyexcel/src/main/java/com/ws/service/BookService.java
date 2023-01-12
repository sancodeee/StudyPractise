package com.ws.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.entity.Book;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface BookService extends IService<Book> {
    boolean insertData(List<Book> list);
}
