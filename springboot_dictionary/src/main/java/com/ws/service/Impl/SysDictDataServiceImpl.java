package com.ws.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.dao.SysDictDataMapper;
import com.ws.po.SysDictData;
import com.ws.service.SysDictDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements SysDictDataService {

    @Override
    @Transactional
    public List<SysDictData> findDictDataByType(String dictType) {
        LambdaQueryWrapper<SysDictData> w = new LambdaQueryWrapper<>();
        w.eq(SysDictData::getDictType, dictType);
        List<SysDictData> sysDictData = getBaseMapper().selectList(w);
        return sysDictData;
    }

    @Override
    @Transactional
    public Map<String, List<SysDictData>> findDictDataByTypes(Collection<String> dictTypes) {
        HashMap map = new HashMap<String, List<SysDictData>>();
        dictTypes.forEach(
                dictType -> {
                    List<SysDictData> sysDictData = getBaseMapper().selectList(new LambdaQueryWrapper<SysDictData>().eq(SysDictData::getDictType, dictType));
                    map.put(dictType,sysDictData);
                }
        );
        return map;
    }

}
