package com.ws.controller;

import com.ws.common.RespResponse.Result;
import com.ws.po.SysDictData;
import com.ws.service.SysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private SysDictDataService sysDictDataService;

    @GetMapping(value = "/findDictByType")
    public Result<?> findDictByType(@RequestParam(value = "dictType") String dictType) {
        List<SysDictData> dictDataByType = sysDictDataService.findDictDataByType(dictType);
        return Result.queryOk(dictDataByType);
    }

    @PostMapping(value = "/findDictMapByTypeList")
    public Result<?> findDictMapByTypeList(@RequestBody Collection<String> dictTypes) {
        Map<String, List<SysDictData>> dictDataByTypes = sysDictDataService.findDictDataByTypes(dictTypes);
        return Result.queryOk(dictDataByTypes);
    }


}
