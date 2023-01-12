package com.ws.mappers;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ws.pojo.Book;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Accessors(chain = true)
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void selectTest(){
        Book book = bookMapper.selectById(1);
        System.out.println(book);
    }

    @Test
    void addTest(){
        Book book = new Book();
//        book.setId(7);
        book.setName("枣花");
        book.setType("_doc");
        book.setDescription("本书描述了早晨的花瓣，夕阳西下的时候拾起来");
        bookMapper.insert(book);
    }

    @Test
    void queryAllTest(){
         bookMapper.selectList(null);
    }

    @Test
    void updateById(){
        Book book = new Book();
        book.setId(2);
        book.setType("文学1");
        book.setName("活着");
        book.setDescription("以中国内战和新中国成立后历次政治运动为背景，通过男主人公福贵一生的坎坷经历，反映了一代中国人的命运。");
        bookMapper.updateById(book);

    }

    //MP分页查询 需要提供拦截器才能实现
    @Test
    void getPageTest(){
        IPage page = new Page(1,5);
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Book::getId);
        IPage<Book> bookIPage = bookMapper.selectPage(page,queryWrapper);
        List<Book> records = bookIPage.getRecords();
        for (int i = 0; i < records.size(); i++) {
            System.out.println(records.get(i));
        }
//        bookMapper.selectPage(page,null);
        //获取当前页
        System.out.println("获取当前起始页："+page.getCurrent());
        System.out.println("获取总页数："+page.getPages());
        System.out.println("获取每页条数："+page.getSize());
        System.out.println("获取库中总数据条数"+page.getTotal());
        System.out.println("得到起始页的对象集合list"+page.getRecords());
    }

    //条件查询
    @Test
    void getByWrapper(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("name","日记");
        List<Book> books = bookMapper.selectList(wrapper);

    }

    //lambda表达式获取字段名称 从而防止字段输入错误
    @Test
    void getByWrapperL(){
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Book::getName,"日记");
        lambdaQueryWrapper.orderByDesc(Book::getId);
        bookMapper.selectList(lambdaQueryWrapper);
    }

    @Test
    void getByWrapperL2(){
        String name = "朝花";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name != null,Book::getName,name);
        bookMapper.selectList(lambdaQueryWrapper);
    }


}
