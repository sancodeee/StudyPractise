package com.ws.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.ws.entity.Book;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class BookListener extends AnalysisEventListener<Book> {

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        log.info("读取表头：" + headMap);
    }

    @Override
    public void invoke(Book book, AnalysisContext analysisContext) {

       log.info("读取一行数据：" + book);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        log.info("所有数据读取完毕！");

    }
}
