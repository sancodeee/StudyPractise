package com.ws.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.google.common.collect.Lists;
import com.ws.entity.Book;
import com.ws.service.BookService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
//创建对象的读取，通过实体对象读取
@Slf4j
public class BookListener extends AnalysisEventListener<Book> {

    //由于Listener不归spring管理 不能在Listener中自动注入BookService
    private final BookService bookService;

    public BookListener(BookService bookService){
        this.bookService = bookService;
    }

    //开辟一个长度为5的list空间当作缓存 防止一次性读取太多条数据内存溢出
    private static final int BATCH_COUNT = 5;
    private List<Book> cachedDataList = Lists.newArrayListWithExpectedSize(BATCH_COUNT);

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        log.info("读取表头：" + headMap + context);
    }

    //读取的每一行数据
    @Override
    public void invoke(Book book, AnalysisContext analysisContext) {

       log.info("读取一行数据：" + book + analysisContext);
       cachedDataList.add(book);
       if(cachedDataList.size() >= BATCH_COUNT){
           //缓存满了就存一次数据库
           savaData(cachedDataList);
           log.info("保存数据完毕：{}",cachedDataList);
           //存完初始化缓存
           cachedDataList = Lists.newArrayListWithExpectedSize(BATCH_COUNT);
       }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        log.info("analysisContext内容：{}",analysisContext);
        log.info("所有数据读取完毕！");

    }

    public void savaData(List cachedDataList){
        //缓存满了往数据库存数据
        boolean saveResult = bookService.insertData(cachedDataList);
        if(saveResult == true){
            log.info("保存数据库成功!");
        }else {
            log.error("保存数据库异常!");
        }
    }
}
