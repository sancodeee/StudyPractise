package com.ws.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.google.common.collect.Lists;
import com.ws.entity.Book;
import com.ws.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
//创建对象的读取，通过实体对象读取
@Slf4j
public class BookListener extends AnalysisEventListener<Book> {

    @Autowired
    private BookService bookService;

    //开辟一个长度为5的list空间当作缓存 防止一次性读取太多条数据内存溢出
    private static final int BATCH_COUNT = 5;
    private List<Book> cachedDataList = Lists.newArrayListWithExpectedSize(BATCH_COUNT);

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        log.info("读取表头：" + headMap);
    }

    @Override
    public void invoke(Book book, AnalysisContext analysisContext) {

       log.info("读取一行数据：" + book);
       cachedDataList.add(book);
       if(cachedDataList.size() >= BATCH_COUNT){
           cachedDataList = Lists.newArrayListWithExpectedSize(BATCH_COUNT);
       }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        log.info("所有数据读取完毕！");

    }

    //数据持久化操作
    public void savaData(){
        //缓存满了往数据库存数据
        boolean saveResult = bookService.saveBatch(cachedDataList);
        if(saveResult == true){
            log.info("数据持久化到数据库成功！");
        }else {
            log.error("数据持久化到数据库异常！");
        }
    }
}
