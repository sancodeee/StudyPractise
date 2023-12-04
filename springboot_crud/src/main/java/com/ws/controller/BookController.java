package com.ws.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ws.controller.result.Result;
import com.ws.pojo.Book;
import com.ws.service.IBookService;
import com.ws.vo.BookNameCountVo;
import com.ws.vo.BookVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    /**
     * 查询全部
     *
     * @return Result
     */
    @GetMapping("/queryAll")
    public Result<List<Book>> getAll() {
        log.info("查询成功");
        return Result.queryOk(iBookService.list());
    }

    /**
     * 根据id查询
     *
     * @param id id
     * @return 统一结果集
     * @throws Exception 异常
     */
    @GetMapping("/getById/{id}")
    public Result<Book> getById(@PathVariable Integer id) throws Exception {
        log.info("查询成功！");
        Book book = iBookService.getBookById(id);
        return Result.queryOk(book);
    }

    /**
     * 根据书名查询
     *
     * @param bookName 书名
     * @return Result结果集
     */
    @GetMapping("/getByName") //@PathParam注解和RequestParam类似，都可以取url路径中的Param，@RequestParam注解还能取body中的Param
    public Result<List<Book>> getByName(@PathParam(value = "bookName") String bookName) {
        List<Book> bookList = iBookService.getBookByName(bookName);
        return Result.queryOk(bookList);
    }

    /**
     * 根据书名分页查询
     *
     * @param bookName 书名
     * @param pageNum  起始页
     * @param pageSize 页大小
     * @return Result统一结果集
     */
    @GetMapping("/getByNamePage")
    public Result<IPage<Book>> getByNamePage(@RequestParam(name = "bookName", required = false, defaultValue = "狂人日记") String bookName,
                                             @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        IPage<Book> bookByNamePage = iBookService.getBookByNamePage(bookName, pageNum, pageSize);
        return Result.queryOk(bookByNamePage);
    }

    /**
     * 分页查询全部
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @return Result统一结果集
     */
    @GetMapping("/getPage/{currentPage}/{pageSize}")
    public Result<IPage<BookVo>> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        log.info("查询成功！");
        return Result.queryOk(iBookService.getPage(currentPage, pageSize));
    }

    /**
     * 根据书名查询该书在数据库中的信息条数
     *
     * @param bookName 书籍名称
     * @return Result统一结果集
     */
    @GetMapping(value = "/getCountByName")
    public Result<Object> getCountByName(@RequestParam(value = "bookName") String bookName) {
        BookNameCountVo countByName = iBookService.getCountByName(bookName);
        return Result.queryOk(countByName);
    }

    /**
     * 根据类型查询该类型在数据库中的条数
     *
     * @param type 书籍类型
     * @return Result统一结果集
     */
    @GetMapping(value = "/getCountByType")
    public Result<Object> getCountByType(@RequestParam(value = "type", required = true) String type) {
        return null;
    }

    /**
     * 添加书记
     *
     * @param book 书籍实体类
     * @return Result统一结果集
     */
    @PostMapping("/save")
    public Result<Book> save(@RequestBody Book book) {
        boolean success = iBookService.save(book);
        return Result.insertOk(book);
    }

    /**
     * 更新
     *
     * @param book 书籍实体类
     * @return Result统一结果集
     */
    @PutMapping("/update")
    public Result<Book> update(@RequestBody Book book) {
        Boolean updateBook = iBookService.updateBook(book);
        return Result.updateOk(book);
    }

    /**
     * 根据id删除书籍
     *
     * @param id id
     * @return Result统一结果集
     */
    @GetMapping("/delete")
    public Result<Book> delete(@RequestParam(name = "id", required = true) Integer id) {
        Boolean book = iBookService.deleteBookById(id);
        if (book == true) {
            return Result.deleteOk(id);
        } else {
            return Result.deleteFail(id);
        }
    }


}
