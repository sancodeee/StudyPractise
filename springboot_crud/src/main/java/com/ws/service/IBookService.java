package com.ws.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.pojo.Book;

public interface IBookService extends IService<Book> {
    //当所需要的方法MP中没有定义时 我们可以自己定义该方法进行操作 注意方法名不要和MP中已有的方法重名 以免覆盖原有方法 从而在使用上造成麻烦
    Boolean saveBook(Book book);

    IPage<Book> getPage(int currentPage,int pageSize);

}
