package com.ws.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.google.common.collect.Lists;
import com.ws.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

//不创建对象读取
@Slf4j
public class BookListenerV2 extends AnalysisEventListener<Map<Integer,String>> {


    //创建指定长度数组当作缓存
    private static final int BATCH_COUNT = 10;
    private List<Map<Integer, String>> cachedDataList = Lists.newArrayListWithExpectedSize(BATCH_COUNT);

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        log.info("读取表头：" + headMap);

    }

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext analysisContext) {
        log.info("解析到一条数据：{}",data);
        //每读取一条数据 就添加到缓存list中去
        cachedDataList.add(data);
        //存满了就保存数据 初始化缓存空间
        if(cachedDataList.size() >= BATCH_COUNT){
            saveData();
            cachedDataList = Lists.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("数据解析完毕！");
    }

    public void saveData(){

        log.info("存储数据：");
    }
}
