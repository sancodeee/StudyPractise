package com.ws.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ws.dto.BookWithAuthor;
import com.ws.entity.Book;
import com.ws.interceptor.annotation.RequestLogin;
import com.ws.service.BookAuthorService;
import com.ws.service.BookService;
import com.ws.vo.BookCompleteVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorService bookAuthorService;

    //查询全部数据
    @ApiOperation(value = "查询全部数据")
    @GetMapping(value = "/getAllBook")
    public List<Book> getAllBook() {
        return bookService.getAllBookList();
    }

    //分页查询全部数据
    @ApiOperation(value = "分页查询全部数据")
    @GetMapping(value = "/getAllBookPage")
    public IPage<Book> getAllBookPage(@ApiParam(value = "当前页码", required = false)
                                      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                      @ApiParam(value = "页长", required = false)
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        IPage<Book> bookPage = bookService.getAllBookPage(pageNum, pageSize);
        return bookPage;
    }

    //方法一：查询全部数据带有作者字段 业务层循环多表查询 时间复杂度为 n²
    @ApiOperation(value = "方法一：查询全部数据带有作者字段（业务逻辑）")
    @GetMapping(value = "/getAllBookWithAuthor")
    public List<BookCompleteVo> getAllBookWithAut() {
        List<BookCompleteVo> allBookWithAuthor = bookService.getAllBookWithAuthor();
        return allBookWithAuthor;
    }

    //方法二：查询全部数据带有作者字段 通过sql进行多表查询 ，该方法比方法一快将近一倍
    @ApiOperation(value = "方法二：查询全部数据带有作者字段（sql）")
    @GetMapping(value = "/getAllBookWithAuthor2")
    public List<BookCompleteVo> getAllBookWithAut2() {
        List<BookCompleteVo> allBookWithAuthor = bookService.getAllBookWithAuthor2();

        return allBookWithAuthor;
    }

    //根据书名查询结果 在业务层手写的多表查询 时间复杂度较高
    @ApiOperation(value = "方法一：根据书名查询结果（业务逻辑）")
    @GetMapping(value = "/getBookByName")
    public List<BookCompleteVo> getBookByName(@ApiParam(value = "书籍名称", required = true)
                                              @RequestParam(value = "name", required = true) String name) {
        return bookService.getBookByName(name);
    }

    //根据书名查询结果 用sql连表查时间复杂度比较低 性能比较好
    @RequestLogin
    @ApiOperation(value = "方法二：根据书名查询结果（sql）")
    @GetMapping(value = "/getBookByName2")
    public List<BookCompleteVo> getBookByName2(@ApiParam(value = "书籍名称", required = true)
                                               @RequestParam(value = "name", required = true) String name) {
        return bookService.getBookByName2(name);
    }

    @ApiOperation(value = "根据书名和类型查询")
    @GetMapping(value = "/getBookByNameAndType")
    public List<BookCompleteVo> getBookByNameAndType(@ApiParam(value = "书籍名称", required = true)
                                                     @RequestParam(value = "name", required = true) String name,
                                                     @ApiParam(value = "书籍类型", required = true)
                                                     @RequestParam(value = "type", required = true) String type) {
        List<BookCompleteVo> bookCompleteVoList = bookService.getBookByNameAndType(name, type);
        return bookCompleteVoList;
    }

    @ApiOperation(value = "根据书名查询书籍详细信息")
    @GetMapping(value = "/getBookAuthorByName")
    public List<BookWithAuthor> getBookAuthorByName(@ApiParam(value = "书籍名称", required = true)
                                                    @RequestParam(value = "name", required = true) String name) {
        List<BookWithAuthor> bookAuthorList = bookAuthorService.getBookByName(name);
        List<BookCompleteVo> t = bookService.getBookByName("张三");
        return bookAuthorList;
    }

    @ApiOperation(value = "根据书名查询书籍详细信息")
    @GetMapping(value = "/getBookAuthorByName2")
    public List<BookWithAuthor> getBookAuthorByName2(@ApiParam(value = "书籍名称", required = true)
                                                    @RequestParam(value = "name", required = true) String name) {
        List<BookWithAuthor> bookAuthorList = bookAuthorService.getBookByName2(name);
        return bookAuthorList;
    }


}
