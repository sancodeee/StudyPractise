package com.ws.lambda.stream;

import com.ws.pojo.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@Slf4j
public class streamDemo01 {

    Book b1 = new Book(1,"寓言故事","doc","本书讲述的都是寓言故事");
    Book b2 = new Book(2,"格林童话","doc2", "本书讲述的都是格林童话111");
    Book b3 = new Book(3,"意林","doc2","本书里边都是短篇小说");
    Book b4 = new Book(4,"活着","doc","本书描述了如何活着");
    Book b5 = new Book(5,"朝花夕拾","doc", "鲁迅先生的作品");
    List<Book> bookList = Stream.of(b1,b2,b3,b4,b5).collect(Collectors.toList());

    @Test
    public void test1(){
        //stream流常用方法：快速创建list，stream创建的是动态数组，可添加元素

        log.info("通过stream流创建list：{}",bookList);

        //filter() 过滤元素：筛选出id大于3 的元素 并存入新的list中
        List<String> afterFilterList = bookList.stream().filter(x -> x.getId() >= 3).map(Book::getName).collect(Collectors.toList());
        log.info("筛选出id大于3的书：{}", afterFilterList);

        //max()/min()/count() 聚合 取描述列最长的字符串的对象 并打印出来
        Optional<String> max = bookList.stream().map(Book::getDescription).max(Comparator.comparing(String::length));
        log.info("description属性中，最长的字符串是：{}",max);

        Optional<String> s = bookList.stream().min(Comparator.comparing(Book::getId)).map(Book::getName);
        log.info("id最小的书是：{}" , s);

        long count = bookList.stream().filter(x -> x.getId() >= 2).count();
        log.info("id大于2的书的个数：{}" , count);

        //映射map/flatMap
        //将bookList中每个id都加3
        List<Integer> collect = bookList.stream().map(Book::getId).map(x -> x + 3).collect(Collectors.toList());
        log.info("将bookList中的id都加3：{}" , collect);
        //将bookList中每个id都加3
        List<Book> bookList2 = bookList.stream().map(x -> {
            x.setId(x.getId() + 3);
            return x;
        }).collect(Collectors.toList());
        log.info("将bookList中元素书的id都加3：{}",bookList2);


    }

    @Test
    public void test2(){
        //reduce规约：也称缩减，顾名思义就是把一个流缩减成一个值，能实现对集合求和，求乘积和求最值操作
        //对book对象中的id求和
        Optional<Integer> reduce = bookList.stream().map(Book::getId).reduce(Integer::sum);
        log.info("所有book对象的id之和为：{}",reduce);

        //求book对象id乘积
        Optional<Integer> reduce1 = bookList.stream().map(Book::getId).reduce((x, y) -> x * y);
        log.info("所有book对象的id乘积为：{}" , reduce1);

        //求book对象id最值
        Integer reduce2 = bookList.stream().map(Book::getId).reduce(1, Integer::max);
        Optional<Integer> reduce22 = bookList.stream().map(Book::getId).reduce((x, y) -> x > y ? x : y);
        log.info("所有book对象中id最大的：{}" , reduce2);

        //归集 常用toList/toSet/toMap
        Map<String, String> map = bookList.stream().filter(x -> x.getId() >= 3).collect(Collectors.toMap(Book::getName, x -> x.getDescription()));
        log.info("选出id大于3的book：{}" , map);

        //分组 partitioningBy/groupingBy
        Map<Boolean, List<Book>> collect = bookList.stream().collect(Collectors.partitioningBy(x -> x.getId() >= 3));
        log.info("按照id大于3将book分组：{}",collect);
        Map<String, List<Book>> map1 = bookList.stream().collect(Collectors.groupingBy(Book::getType));
        log.info("按照book类型分组：{}",map1);

        //join拼接
        String s = bookList.stream().map(Book::getName).collect(Collectors.joining("-"));
        log.info("将所有book对象中的name属性拼接成一个字符串：{}",s);


    }

    @Test
    public void test03(){
        //自然排序
        List<String> List3 = bookList.stream().sorted(Comparator.comparing(Book::getId)).map(Book::getName).collect(Collectors.toList());
        log.info("按照id大小顺序排序：{}", List3);

        //倒序排序.reversed()
        List<Book> List1 = bookList.stream().sorted(Comparator.comparing(Book::getId).reversed()).collect(Collectors.toList());
        List<String> List2 = List1.stream().sorted(Comparator.comparing(Book::getId).reversed()).map(Book::getName).collect(Collectors.toList());
        log.info("按照id倒序排序：{}", List1);
        log.info("按照id倒序排序：{}", List2);

        //先按id排序从小到大自然排序 再按类型排序
        List<String> collect = bookList.stream().sorted(Comparator.comparing(Book::getId).thenComparing(Book::getType)).map(Book::getName)
                .collect(Collectors.toList());
        log.info("先按id自然排序，再按类型排序：{}",collect);
        List<String> collect1 = bookList.stream().sorted(Comparator.comparing(Book::getType).thenComparing(Book::getId)).map(Book::getName)
                .collect(Collectors.toList());
        log.info("先按类型排序，再按照id自然排序：{}",collect1);

    }




}
