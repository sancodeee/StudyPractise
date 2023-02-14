package com.ws.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.pojo.Book;

import java.util.List;

public interface IBookService extends IService<Book> {

    //当所需要的方法MP中没有定义时 我们可以自己定义该方法进行操作 注意方法名不要和MP中已有的方法重名 以免覆盖原有方法 从而在使用上造成麻烦
    Boolean saveBook(Book book);

    //分页查询全部
    IPage<Book> getPage(int currentPage,int pageSize);

    //根据书名查询书籍
    List<Book> getBookByName(String bookName);

    //根据书名分页查询
    IPage<Book> getBookByNamePage(String bookName , Integer pageNum , Integer pageSize);

    //更新书籍
    Boolean updateBook(Book book);

    //根据id删除书籍
    Boolean deleteBookById(Integer id);

}
