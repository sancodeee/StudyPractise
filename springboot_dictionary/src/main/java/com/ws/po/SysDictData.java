package com.ws.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_dict_data")
public class SysDictData {

    @TableId(value = "dict_code", type = IdType.AUTO)
    private Integer dictCode;

    @TableField("dict_sort")
    private Integer dictSort;

    @TableField("dict_label")
    private String dictLabel;

    @TableField("dict_value")
    private String dictValue;

    @TableField("dict_type")
    private String dictType;

    @TableField("css_class")
    private String cssClass;

    @TableField("list_class")
    private String listClass;

    @TableField("is_default")
    private String isDefault;

    @TableField("status")
    private String status;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;

}
