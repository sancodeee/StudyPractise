package com.ws.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.po.SysDictData;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface SysDictDataService extends IService<SysDictData> {

    //根据类型获取数据字典信息
    List<SysDictData> findDictDataByType(String dataType);

    Map<String, List<SysDictData>> findDictDataByTypes(Collection<String> dataTypes);

}
